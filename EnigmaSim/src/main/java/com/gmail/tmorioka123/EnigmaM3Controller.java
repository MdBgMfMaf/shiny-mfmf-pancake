package com.gmail.tmorioka123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gmail.tmorioka123.repositories.ETypeSettingRepository;
import com.gmail.tmorioka123.repositories.PbSettingRepository;
import com.gmail.tmorioka123.repositories.RRSettingRepository;
import com.gmail.tmorioka123.repositories.RRTypeSettingRepository;
import com.gmail.tmorioka123.repositories.UKWDSettingRepository;

import jakarta.annotation.PostConstruct;

@Controller
public class EnigmaM3Controller {

	private final ETypeSettingRepository eRepository;
	private final PbSettingRepository pRepository;
	private final RRTypeSettingRepository rTRepository;
	private final RRSettingRepository rRepository;
	private final UKWDSettingRepository dRepository;
	private final EnigmaDataManager edm;
	private EnigmaMain enigma;
	private RRTypeSetting rrTSet;

	private final int rrTypeSetID=2;
	private final int enigmaTypeID=1;
	private final int refOffset=1;

	@Autowired
	public EnigmaM3Controller(ETypeSettingRepository eRepository,PbSettingRepository pRepository,
			RRTypeSettingRepository rTRepository,RRSettingRepository rRepository,UKWDSettingRepository dRepository) {
		this.eRepository=eRepository;
		this.pRepository = pRepository;
		this.rTRepository=rTRepository;
		this.rRepository = rRepository;
		this.dRepository = dRepository;

		this.rrTSet=new RRTypeSetting(rrTypeSetID);
		rrTSet.setRefType(refOffset);

		this.edm=new EnigmaDataManager();
		this.enigma=new EnigmaMain();
	}
	@PostConstruct
	public void setEnigmaData() {
		eRepository.saveAndFlush(new ETypeSetting());
		pRepository.saveAndFlush(new PbSetting());
		rTRepository.saveAndFlush(this.rrTSet);
		rRepository.saveAndFlush(new RRSetting());
		dRepository.saveAndFlush(new UKWDSetting());
	}
	@ModelAttribute(name="rrTSet")
	public RRTypeSetting init () {
		RRTypeSetting rrTSet=rTRepository.findById(rrTypeSetID).get();
		return rrTSet;
	}
	@ModelAttribute(name="rrSet")
	public RRSetting setRRSet () {
		RRSetting rrSet=rRepository.findById(1).get();
		return rrSet;
	}
	@ModelAttribute(name="pbSet")
	public PbSetting setPbSet () {
		PbSetting pbSet=pRepository.findById(1).get();
		return pbSet;
	}
	@ModelAttribute(name="dSet")
	public UKWDSetting setDSet () {
		UKWDSetting dSet=dRepository.findById(1).get();
		return dSet;
	}
	@RequestMapping(value = "/enigma_M3/", method = RequestMethod.GET)
	public ModelAndView start(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav) {
		mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
		mav.addObject("edm", this.edm);
		mav.setViewName("/enigma_M3/index");
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/index", method = RequestMethod.GET)
	public ModelAndView showIndex(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav) {
		mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
		edm.checkAndValidateAllSetting(pbSet, rrTSet, rrSet, dSet);
		mav.addObject("edm", this.edm);
		mav.setViewName("/enigma_M3/index");
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/rrSetting",method = RequestMethod.GET)
	public ModelAndView showRotorRefSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
		mav.addObject("edm", this.edm);
		mav.setViewName("/enigma_M3/rrSetting");
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/rrSetting",method = RequestMethod.POST)
	public ModelAndView setRotorRefSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		dSet=dRepository.findById(1).get();
		int refSet=rrTSet.getRefType();
		rrTSet.setRefType(refSet+refOffset);
		if(rrTSet.getRefType()==3) {
			this.edm.setHasUKWD(true);
			this.edm.setUKWDValid(edm.checkIsUKWDSetValid(dSet.getUkwDSet0(),dSet.getUkwDSet1(),dSet.getUkwDSet2(),dSet.getUkwDSet3(),
						dSet.getUkwDSet4(),dSet.getUkwDSet5(),dSet.getUkwDSet6(),dSet.getUkwDSet7(),
						dSet.getUkwDSet8(),	dSet.getUkwDSet9(),dSet.getUkwDSet10(),dSet.getUkwDSet11()));
			System.out.println(edm.checkIsUKWDSetValid(dSet.getUkwDSet0(),dSet.getUkwDSet1(),dSet.getUkwDSet2(),dSet.getUkwDSet3(),
						dSet.getUkwDSet4(),dSet.getUkwDSet5(),dSet.getUkwDSet6(),dSet.getUkwDSet7(),
						dSet.getUkwDSet8(),	dSet.getUkwDSet9(),dSet.getUkwDSet10(),dSet.getUkwDSet11()));
		}else {
			this.edm.setHasUKWD(false);
			this.edm.setUKWDValid(true);
		}
		rTRepository.saveAndFlush(rrTSet);
		rRepository.saveAndFlush(rrSet);
		return new ModelAndView("redirect:/enigma_M3/index");
	}
	@RequestMapping(value = "/enigma_M3/pbSetting",method = RequestMethod.GET)
	public ModelAndView showPlugboardSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
		mav.addObject("edm", this.edm);
		mav.setViewName("/enigma_M3/pbSetting");
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/pbSetting",method = RequestMethod.POST)
	public ModelAndView setPlugboardSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		if(edm.checkIsPbSetValid(pbSet.getPbSet0(),pbSet.getPbSet1(),pbSet.getPbSet2(),pbSet.getPbSet3(),
				pbSet.getPbSet4(),pbSet.getPbSet5(),pbSet.getPbSet6(),pbSet.getPbSet7(),pbSet.getPbSet8()
				,pbSet.getPbSet9())) {
			pRepository.saveAndFlush(pbSet);
			edm.setPbValid(true);
			return new ModelAndView("redirect:/enigma_M3/index");
		}
		pRepository.saveAndFlush(pbSet);
		mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
		mav.addObject("Msg", "値が不正です。確認し入力しなおしてください。");
		this.edm.setPbValid(false);
		mav.addObject("edm",this.edm);
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/pbSetting/random",method = RequestMethod.GET)
	public ModelAndView setRandomPbSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,
			@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		String[]values=edm.setRandomPbSet();
		pbSet.setPbSet0(values[0]);
		pbSet.setPbSet1(values[1]);
		pbSet.setPbSet2(values[2]);
		pbSet.setPbSet3(values[3]);
		pbSet.setPbSet4(values[4]);
		pbSet.setPbSet5(values[5]);
		pbSet.setPbSet6(values[6]);
		pbSet.setPbSet7(values[7]);
		pbSet.setPbSet8(values[8]);
		pbSet.setPbSet9(values[9]);
		pRepository.saveAndFlush(pbSet);
		this.edm.setPbValid(true);
		return new ModelAndView("redirect:/enigma_M3/index");
	}


	@RequestMapping(value = "/enigma_M3/ukwDSetting",method = RequestMethod.GET)
	public ModelAndView showUKWDSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
		mav.addObject("edm", this.edm);
		mav.addObject("Msg", "");
		mav.setViewName("/enigma_M3/ukwDSetting");
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/ukwDSetting",method = RequestMethod.POST)
	public ModelAndView setUKWDSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		if(edm.checkIsUKWDSetValid(dSet.getUkwDSet0(),dSet.getUkwDSet1(),dSet.getUkwDSet2(),dSet.getUkwDSet3(),
				dSet.getUkwDSet4(),dSet.getUkwDSet5(),dSet.getUkwDSet6(),dSet.getUkwDSet7(),
				dSet.getUkwDSet8(),	dSet.getUkwDSet9(),dSet.getUkwDSet10(),dSet.getUkwDSet11())) {
			dRepository.saveAndFlush(dSet);
			this.edm.setUKWDValid(true);
			return new ModelAndView("redirect:/enigma_M3/index");
		}else{
			dRepository.saveAndFlush(dSet);
			mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
			mav.addObject("Msg", "値が不正です。確認し入力しなおしてください。");
			this.edm.setUKWDValid(false);
			mav.addObject("edm",this.edm);
			return mav;
		}
	}
	@RequestMapping(value = "/enigma_M3/ukwDSetting/random",method = RequestMethod.GET)
	public ModelAndView setRandomUKWDSetting(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,
			@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		String[]values=edm.setRandomUKWDSet();
		dSet.setUkwDSet0(values[0]);
		dSet.setUkwDSet1(values[1]);
		dSet.setUkwDSet2(values[2]);
		dSet.setUkwDSet3(values[3]);
		dSet.setUkwDSet4(values[4]);
		dSet.setUkwDSet5(values[5]);
		dSet.setUkwDSet6(values[6]);
		dSet.setUkwDSet7(values[7]);
		dSet.setUkwDSet8(values[8]);
		dSet.setUkwDSet9(values[9]);
		dSet.setUkwDSet10(values[10]);
		dSet.setUkwDSet11(values[11]);
		dRepository.saveAndFlush(dSet);
		this.edm.setUKWDValid(true);
		return new ModelAndView("redirect:/enigma_M3/index");
	}
	@RequestMapping(value = "/enigma_M3/modelChange", method = RequestMethod.GET)
	public ModelAndView showModelChange(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){
		mav=regetSetting(pbSet,rrTSet,rrSet, dSet, mav);
		mav.addObject("edm", this.edm);
		mav.setViewName("/enigma_M3/modelChange");
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/modelChange", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView setModelChange(@RequestParam int enigmaType,@ModelAttribute("eTSet") ETypeSetting eTSet,
			@ModelAttribute("pbSet") PbSetting pbSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,@ModelAttribute("iom")InputOutputManager iom,
			ModelAndView mav){

		mav=new ModelAndView();

		switch(enigmaType) {
		case 0:mav.setViewName("redirect:/enigma_I/index");
		break;
		case 1:mav.setViewName("redirect:/enigma_M3/index");
		break;
		case 2:mav.setViewName("redirect:/enigma_M4/index");
		break;
		}
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/instruction", method = RequestMethod.GET)
	public ModelAndView showInstruction(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,
			@ModelAttribute("iom")InputOutputManager iom,ModelAndView mav){
		mav=regetSetting(pbSet, rrTSet, rrSet, dSet, mav);
		mav.addObject("edm", this.edm);
		mav.setViewName("/enigma_M3/instruction");
		return mav;
	}
	@RequestMapping(value = "/enigma_M3/doEnigma", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView doEnigma(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet,
			@ModelAttribute("iom")InputOutputManager iom,ModelAndView mav){
		mav.addObject("pbSet", pbSet);
		mav.addObject("rrTSet", rrTSet);
		mav.addObject("rrSet", rrSet);
		mav.addObject("dSet", dSet);
		mav.addObject("edm", this.edm);

		if(this.edm.isPbValid()&&this.edm.isRRvalid()&&this.edm.isUKWDValid()&&this.edm.isNotHasBothUKWDandThin()) {
			String s= iom.getInput();
			setValuesToEnigma(pbSet,rrTSet,rrSet, dSet);
			iom.setOutput(enigma.executeEnigma(s));
			mav.addObject("output", iom.getOutput());
			mav.setViewName("/enigma_M3/index");
			return mav;
		}else {
			mav.addObject("Msg","エニグマの設定が不正なため、実行できませんでした。");
			mav.setViewName("/enigma_M3/index");
			return mav;
		}
	}
	public ModelAndView regetSetting(PbSetting pbSet,RRTypeSetting rrTSet,
			RRSetting rrSet,UKWDSetting dSet,
			ModelAndView mav) {
		mav=new ModelAndView();

		pbSet=pRepository.findById(1).get();
		rrTSet=rTRepository.findById(rrTypeSetID).get();
		rrSet=rRepository.findById(1).get();
		dSet=dRepository.findById(1).get();

		mav.addObject("pbSet", pbSet);
		mav.addObject("rrTSet", rrTSet);
		mav.addObject("rrSet", rrSet);
		mav.addObject("dSet", dSet);

		mav.addObject("selectedRefValue", rrTSet.getRefType()-refOffset);

		mav.addObject("selectedTRotorValue",rrTSet.gettRotorType());
		mav.addObject("selectedLRotorValue",rrTSet.getlRotorType());
		mav.addObject("selectedMRotorValue",rrTSet.getmRotorType());
		mav.addObject("selectedRRotorValue",rrTSet.getrRotorType());

		mav.addObject("selectedTRotorStartValue",rrSet.gettRotorStart());
		mav.addObject("selectedLRotorStartValue",rrSet.getlRotorStart());
		mav.addObject("selectedMRotorStartValue",rrSet.getmRotorStart());
		mav.addObject("selectedRRotorStartValue",rrSet.getrRotorStart());
		mav.addObject("selectedTRotorRingValue",rrSet.gettRotorRing());
		mav.addObject("selectedLRotorRingValue",rrSet.getrRotorRing());
		mav.addObject("selectedMRotorRingValue",rrSet.getmRotorRing());
		mav.addObject("selectedRRotorRingValue",rrSet.getlRotorRing());

		mav.addObject("selectedPbSet0Value", pbSet.getPbSet0());
		mav.addObject("selectedPbSet1Value", pbSet.getPbSet1());
		mav.addObject("selectedPbSet2Value", pbSet.getPbSet2());
		mav.addObject("selectedPbSet3Value", pbSet.getPbSet3());
		mav.addObject("selectedPbSet4Value", pbSet.getPbSet4());
		mav.addObject("selectedPbSet5Value", pbSet.getPbSet5());
		mav.addObject("selectedPbSet6Value", pbSet.getPbSet6());
		mav.addObject("selectedPbSet7Value", pbSet.getPbSet7());
		mav.addObject("selectedPbSet8Value", pbSet.getPbSet8());
		mav.addObject("selectedPbSet9Value", pbSet.getPbSet9());

		mav.addObject("selectedUKWDSet0Value", dSet.getUkwDSet0());
		mav.addObject("selectedUKWDSet1Value", dSet.getUkwDSet1());
		mav.addObject("selectedUKWDSet2Value", dSet.getUkwDSet2());
		mav.addObject("selectedUKWDSet3Value", dSet.getUkwDSet3());
		mav.addObject("selectedUKWDSet4Value", dSet.getUkwDSet4());
		mav.addObject("selectedUKWDSet5Value", dSet.getUkwDSet5());
		mav.addObject("selectedUKWDSet6Value", dSet.getUkwDSet6());
		mav.addObject("selectedUKWDSet7Value", dSet.getUkwDSet7());
		mav.addObject("selectedUKWDSet8Value", dSet.getUkwDSet8());
		mav.addObject("selectedUKWDSet9Value", dSet.getUkwDSet9());
		mav.addObject("selectedUKWDSet10Value", dSet.getUkwDSet10());
		mav.addObject("selectedUKWDSet11Value", dSet.getUkwDSet11());

		mav.addObject("refTypeByName1",edm.getRefsetByName1());
		mav.addObject("rotorTypeByNameForM", edm.getRotorSetByNameForM());
		mav.addObject("Alphabets",edm.getAlphabetsbyletter());
		return mav;
	}

	public void setValuesToEnigma(@ModelAttribute("pbSet") PbSetting pbSet,@ModelAttribute("rrTSet")RRTypeSetting rrTSet,
			@ModelAttribute("rrSet")RRSetting rrSet,@ModelAttribute("dSet")UKWDSetting dSet) {

		enigma.constructEnigma(enigmaTypeID,rrTSet.getRefType(),rrTSet.gettRotorType(),
				rrTSet.getlRotorType(),rrTSet.getmRotorType(),rrTSet.getrRotorType(),rrSet.gettRotorStart(),
				rrSet.getlRotorStart(),rrSet.getmRotorStart(),rrSet.getrRotorStart(),rrSet.gettRotorRing(),
				rrSet.getrRotorRing(),rrSet.getmRotorRing(),rrSet.getlRotorRing(),
				pbSet.getPbSet0(),pbSet.getPbSet1(),pbSet.getPbSet2(),pbSet.getPbSet3(),
				pbSet.getPbSet4(),pbSet.getPbSet5(),pbSet.getPbSet6(),pbSet.getPbSet7(),
				pbSet.getPbSet8(),pbSet.getPbSet9(),
				dSet.getUkwDSet0(),dSet.getUkwDSet1(),dSet.getUkwDSet2(),dSet.getUkwDSet3(),
				dSet.getUkwDSet4(),dSet.getUkwDSet5(),dSet.getUkwDSet6(),dSet.getUkwDSet7(),
				dSet.getUkwDSet8(),	dSet.getUkwDSet9(),dSet.getUkwDSet10(),dSet.getUkwDSet11(),edm.isHasUKWD());
	}
}
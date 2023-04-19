package com.gmail.tmorioka123;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gmail.tmorioka123.repositories.PbSettingRepository;
import com.gmail.tmorioka123.repositories.RRSettingRepository;
import com.gmail.tmorioka123.repositories.RRTypeSettingRepository;
import com.gmail.tmorioka123.repositories.UKWDSettingRepository;


@Controller
public class MainController {
	private final PbSettingRepository pRepository;
	private final RRTypeSettingRepository rTRepository;
	private final RRSettingRepository rRepository;
	private final UKWDSettingRepository dRepository;


	@Autowired
	public MainController(PbSettingRepository pRepository,RRTypeSettingRepository rTRepository,
			RRSettingRepository rRepository,UKWDSettingRepository dRepository) {
		this.pRepository = pRepository;
		this.rTRepository=rTRepository;
		this.rRepository = rRepository;
		this.dRepository = dRepository;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView start(ModelAndView mav) {
		return new ModelAndView("redirect:/enigma_I/index");
	}
	@GetMapping(value="/enigmaSetting.csv",params="download_file",
			produces =MediaType.APPLICATION_OCTET_STREAM_VALUE + 
			"; charset=UTF-8;Content-Disposition:attachment"
			)
	@ResponseBody
	public Object index()throws JsonProcessingException{
		int fixedId=1;
		CsvMapper mapper =new CsvMapper();
		CsvSchema schema = mapper.schemaFor(EnigmaSettingCsv.class).withHeader();
		RRTypeSetting rrTSet0 =rTRepository.findById(1).get();
		RRTypeSetting rrTSet1 =rTRepository.findById(2).get();
		RRTypeSetting rrTSet2 =rTRepository.findById(3).get();
		RRSetting rrSet=rRepository.findById(fixedId).get();
		PbSetting pbSet=pRepository.findById(fixedId).get();
		UKWDSetting dSet=dRepository.findById(fixedId).get();
		EnigmaSettingCsv eSetCsv=new EnigmaSettingCsv(rrTSet0.getrRotorType(),rrTSet0.getmRotorType(),
				rrTSet0.getlRotorType(),rrTSet0.getRefType(),rrTSet0.gettRotorType(),rrTSet1.getrRotorType(),
				rrTSet1.getmRotorType(),rrTSet1.getlRotorType(),rrTSet1.getRefType(),rrTSet1.gettRotorType(),
				rrTSet2.getrRotorType(),rrTSet2.getmRotorType(),rrTSet2.getlRotorType(),rrTSet2.getRefType(),
				rrTSet2.gettRotorType(),rrSet.getrRotorStart(),rrSet.getrRotorRing(),rrSet.getmRotorStart(),
				rrSet.getmRotorRing(),rrSet.getlRotorStart(),rrSet.getlRotorRing(),
				rrSet.gettRotorStart(),rrSet.gettRotorRing(),pbSet.getConbinedPbSet(),
				dSet.getConbinedUkwDSet());
		return mapper.writer(schema).writeValueAsString(eSetCsv);
	}
	@PostMapping(value="/",params="upload_file")
	public String uploadFile(@RequestParam("file")MultipartFile uploadFile) {
		
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(uploadFile.getInputStream(),
				StandardCharsets.UTF_8))){
			String line="";
			reader.readLine();
			String[]splitData=(reader.readLine().split(","));
			
			int fixedId=1;
			RRTypeSetting rrTSet0 =rTRepository.findById(1).get();
			RRTypeSetting rrTSet1 =rTRepository.findById(2).get();
			RRTypeSetting rrTSet2 =rTRepository.findById(3).get();
			RRSetting rrSet=rRepository.findById(fixedId).get();
			PbSetting pbSet=pRepository.findById(fixedId).get();
			UKWDSetting dSet=dRepository.findById(fixedId).get();
			
			rrTSet0.setrRotorType(Integer.parseInt(splitData[0]));
			rrTSet0.setmRotorType(Integer.parseInt(splitData[1]));
			rrTSet0.setlRotorType(Integer.parseInt(splitData[2]));
			rrTSet0.setRefType(Integer.parseInt(splitData[3]));
			rrTSet0.settRotorType(Integer.parseInt(splitData[4]));
			rrTSet1.setrRotorType(Integer.parseInt(splitData[5]));
			rrTSet1.setmRotorType(Integer.parseInt(splitData[6]));
			rrTSet1.setlRotorType(Integer.parseInt(splitData[7]));
			rrTSet1.setRefType(Integer.parseInt(splitData[8]));
			rrTSet1.settRotorType(Integer.parseInt(splitData[9]));
			rrTSet2.setrRotorType(Integer.parseInt(splitData[10]));
			rrTSet2.setmRotorType(Integer.parseInt(splitData[11]));
			rrTSet2.setlRotorType(Integer.parseInt(splitData[12]));
			rrTSet2.setRefType(Integer.parseInt(splitData[13]));
			rrTSet2.settRotorType(Integer.parseInt(splitData[14]));
			
			rrSet.setrRotorStart(Integer.parseInt(splitData[15]));
			rrSet.setrRotorRing(Integer.parseInt(splitData[16]));
			rrSet.setmRotorStart(Integer.parseInt(splitData[17]));
			rrSet.setmRotorRing(Integer.parseInt(splitData[18]));
			rrSet.setlRotorStart(Integer.parseInt(splitData[19]));
			rrSet.setlRotorRing(Integer.parseInt(splitData[20]));
			rrSet.settRotorStart(Integer.parseInt(splitData[21]));
			rrSet.settRotorRing(Integer.parseInt(splitData[22]));
			
			char[]chars=splitData[23].toCharArray();
			String[]strs={"","","","","","","","","",""};
			for(int i=0,j=0;i<chars.length;i++) {
				if(0<i&&i%2==0) {
					j++;
				}
				strs[j]+=chars[i];
			}
			pbSet.setPbSet0(strs[0]);
			pbSet.setPbSet1(strs[1]);
			pbSet.setPbSet2(strs[2]);
			pbSet.setPbSet3(strs[3]);
			pbSet.setPbSet4(strs[4]);
			pbSet.setPbSet5(strs[5]);
			pbSet.setPbSet6(strs[6]);
			pbSet.setPbSet7(strs[7]);
			pbSet.setPbSet8(strs[8]);
			pbSet.setPbSet9(strs[9]);
			
			chars=splitData[24].toCharArray();
			strs= new String[]{"","","","","","","","","","","",""};
			for(int i=0,j=0;i<chars.length;i++) {
				if(0<i&&i%2==0) {
					j++;
				}
				strs[j]+=chars[i];
			}
			dSet.setUkwDSet0(strs[0]);
			dSet.setUkwDSet1(strs[1]);
			dSet.setUkwDSet2(strs[2]);
			dSet.setUkwDSet3(strs[3]);
			dSet.setUkwDSet4(strs[4]);
			dSet.setUkwDSet5(strs[5]);
			dSet.setUkwDSet6(strs[6]);
			dSet.setUkwDSet7(strs[7]);
			dSet.setUkwDSet8(strs[8]);
			dSet.setUkwDSet9(strs[9]);
			dSet.setUkwDSet10(strs[10]);
			dSet.setUkwDSet11(strs[11]);
			
			rTRepository.saveAndFlush(rrTSet0);
			rTRepository.saveAndFlush(rrTSet1);
			rTRepository.saveAndFlush(rrTSet2);
			rRepository.saveAndFlush(rrSet);
			pRepository.saveAndFlush(pbSet);
			dRepository.saveAndFlush(dSet);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
		
	}
}


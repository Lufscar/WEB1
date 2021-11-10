package br.ufscar.dc.dsw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class CtoF_Controller {

	@RequestMapping("/CtoF_Spring")
	public String converter(@RequestParam("minVal") String minVal,@RequestParam("maxVal") String maxVal,@RequestParam("incVal") String incVal, Model model){  
		
		double min = (minVal == null || minVal.isEmpty()) ? -100 : Integer.parseInt(minVal);

		double max = (maxVal == null || maxVal.isEmpty()) ? 100 : Integer.parseInt(maxVal);

		double inc = (incVal == null || incVal.isEmpty()) ? 5 : Integer.parseInt(incVal);
		
		/*model conv = new model(0, 0);

		for (conv.celsius = min; conv.celsius <= max; conv.celsius += inc) {
			conv.fahr = 1.8 * conv.celsius + 32;
			model.addAttribute("conv", conv.fahr);
			model.addAttribute("conv", conv.celsius);

		}*/
		
		ArrayList <Double> cel_list = new ArrayList <Double>();
		ArrayList <Double> fah_list = new ArrayList <Double>();
		
		for (double celsius = min; celsius<=max; celsius += inc) {
			double fahr= 1.8 * celsius + 32;
			cel_list.add(celsius);
			fah_list.add(fahr);
		}
		
		model.addAttribute("celsius", cel_list);
		model.addAttribute("fahr", fah_list);

		return "CtoF_Spring.html";
	}
}

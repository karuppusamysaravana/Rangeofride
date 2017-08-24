package com.rangeofride.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;
import org.hibernate.Transaction;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rangeofride.dao.*;
import com.rangeofride.model.*;

@Controller
public class HomeController
{


	@Autowired
	registerdao d;
	
	@Autowired
	productdao  p;
	

	@Autowired
	supplierdao  s;
	
	@Autowired
	categorydao  c;

	@RequestMapping(value={"/","/home"})
	String indexPage() {
		return "index";
	}

	String IndexPage() {
		
		return "index";
	}

	@RequestMapping("/contact")
	String contactPage() {
		return "contact";
	}

	@RequestMapping("/log")
	String logPage() {
		return "log";
	}

	@RequestMapping("/signup")
	String signupPage(Model M)
	{
		M.addAttribute("RegModel", new Register());
		return "signup";
	}

	@RequestMapping("/aboutus")
	String aboutusPage() 
	{
		return "aboutus";
	}
	
	@RequestMapping("/category")
	String catPage(Model M)
	{
		M.addAttribute("CatModel", new category());
		M.addAttribute("CatTable",c.showAll());
		M.addAttribute("check", false);
		return "category";
	}
	
	
	@RequestMapping("/product")
	String proPage(Model M)
	{
		M.addAttribute("ProModel", new product());
		M.addAttribute("ProTable",p.showAll());
		M.addAttribute("check", false);
		return "product";
	}
	

	@RequestMapping("/supplier")
	String suppPage(Model M)
	{
		M.addAttribute("SuppModel", new supplier());
		M.addAttribute("SuppTable",s.showAll());
		M.addAttribute("check", false);
		return "supplier";
		
	}

	@RequestMapping(value="/getreg", method=RequestMethod.POST)
	String getreg(@Valid @ModelAttribute("RegModel") Register k, BindingResult br, Model M) 
	{
		System.out.println("welcome");
		System.out.println();
		if (br.hasErrors()) 
		{
			System.out.println(br.getAllErrors());
			M.addAttribute("RegModel", k);
			return "log";
		} 
		else
		{
			if (d.insert(k))
			{
					return "log";
			}
			else
			{
				System.out.println("error because backend");
				M.addAttribute("RegModel", k);
				return "log";
			}
		}

	}

	@RequestMapping(value="/getproduct")
	String getproduct(@Valid @ModelAttribute("ProModel") product k, BindingResult br, Model M) throws IOException 
	{
		System.out.println("welcome");
		if (br.hasErrors()) 
		{
			System.out.println(br.getAllErrors());
			M.addAttribute("ProModel", k);
			M.addAttribute("ProTable",p.showAll());
			return "product";
		} 
		else
		{

			if (p.insert(k))
			{

				String Filepath="C:\\s181144300069\\rangeofridefrontend\\src\\main\\webapp\\resources\\productimages\\";
				Filepath=Filepath+String.valueOf(k.getpId())+".jpg";
				File f=new File(Filepath);
				System.out.println(Filepath);
				MultipartFile imageFile=k.getProductImage();
				if(!f.exists())
				{
					byte[] imageBytes=imageFile.getBytes();
					FileOutputStream fos=new FileOutputStream(f);
					fos.write(imageBytes);
					fos.close();
				}
					return "redirect:/product";
			}
			else
			{
				System.out.println("error because backend");
				M.addAttribute("ProModel", k);
				M.addAttribute("ProTable",p.showAll());
				return "product";
			}
		}
	}
	
	
	
	
	@RequestMapping(value="/putproduct")
	String putproduct(@Valid @ModelAttribute("ProModel") product k, BindingResult br, Model M) 
	{
		System.out.println("welcome");
		if (br.hasErrors()) 
		{
			System.out.println(br.getAllErrors());
			M.addAttribute("ProModel", k);
			M.addAttribute("ProTable",p.showAll());
			return "product";
		} 
		else
		{

			if (p.update(k))
					return "redirect:/product";
			else
			{
				System.out.println("error because backend");
				M.addAttribute("ProModel", k);
				M.addAttribute("ProTable",p.showAll());
				return "product";
			}
		}
	}



        @RequestMapping(value="/getsupplier")
		String getsupplier(@Valid @ModelAttribute("SuppModel") supplier n, BindingResult br, Model M) 
		{
			System.out.println("welcome");
			if (br.hasErrors()) 
			{
				System.out.println(br.getAllErrors());
				M.addAttribute("SuppModel", n);
				M.addAttribute("SuppTable",s.showAll());
				return "supplier";
			} 
			else
			{

				if (s.insert(n))
						return "redirect:/supplier";
				else
				{
					System.out.println("error because backend");
					M.addAttribute("SuppModel", n);
					M.addAttribute("SuppTable",s.showAll());
					return "supplier";
				}
			}

		}

        @RequestMapping(value="/putsupplier")
		String putsupplier(@Valid @ModelAttribute("SuppModel") supplier n, BindingResult br, Model M) 
		{
			System.out.println("welcome");
			if (br.hasErrors()) 
			{
				System.out.println(br.getAllErrors());
				M.addAttribute("SuppModel", n);
				M.addAttribute("SuppTable",s.showAll());
				return "supplier";
			} 
			else
			{

				if (s.update(n))
						return "redirect:/supplier";
				else
				{
					System.out.println("error because backend");
					M.addAttribute("SuppModel", n);
					M.addAttribute("SuppTable",s.showAll());
					return "supplier";
				}
			}

		}

        

	      @RequestMapping(value="/getcat")
	      String getcat(@Valid @ModelAttribute("CatModel") category o, BindingResult br, Model M) 
        {
		   System.out.println("welcome");
		   if (br.hasErrors()) 
		{
			System.out.println(br.getAllErrors());
			M.addAttribute("CatModel", o);
			M.addAttribute("CatTable",c.showAll());
			return "category";
		} 
		else
		{
			if (c.insert(o))
				return "redirect:/category";
			else
			{
				System.out.println("error because backend");
				M.addAttribute("CatModel", o);
				M.addAttribute("CatTable",c.showAll());
				return "category";
			}
		}

	}
	
	
	@RequestMapping(value="/putcat")
	String putcat(@Valid @ModelAttribute("CatModel") category o, BindingResult br, Model M) 
	{
		System.out.println("welcome");
		if (br.hasErrors()) 
		{
			System.out.println(br.getAllErrors());
			M.addAttribute("CatModel", o);
			M.addAttribute("CatTable",c.showAll());
			return "category";
		} 
		else
		{
			if (c.update(o))
				return "redirect:/category";
			else
			{
				System.out.println("error because backend");
				M.addAttribute("CatModel", o);
				M.addAttribute("CatTable",c.showAll());
				return "category";
			}
		}

	}
	
	
	
      @RequestMapping("/removecat/{num}")
      String removecat(@PathVariable("num")int id){
    	  if (c.delete(id)){
    		  return "redirect:/category";
    	  }
    	  else{
    		  return "category";
    	  }
      }
      
      @RequestMapping("/removesupp/{num}")
      String removesupp(@PathVariable("num")int id){
    	  if (s.delete(id)){
    		  return "redirect:/supplier";
    	  }
    	  else{
    		  return "supplier";
    	  }
      }

      @RequestMapping("/removepro/{num}")
      String removepro(@PathVariable("num")int id){
    	  if (p.delete(id)){
    		  return "redirect:/product";
    	  }
    	  else{
    		  return "product";
    	  }
      }
     @RequestMapping("/suppedit")  
     String suppedit(@RequestParam("getSid")int id,Model l){
    	 
    	 l.addAttribute("SuppModel",s.showOne(id));
    	 l.addAttribute("SuppTable",s.showAll());
    	 l.addAttribute("check", true);
    	   return "supplier";
     }
    	   
     @RequestMapping("/proedit")  
     String supedit(@RequestParam("getpId")int id,Model l){
    	    	 
    	 l.addAttribute("ProModel",p.showOne(id));
    	 l.addAttribute("ProTable",p.showAll());
    	 l.addAttribute("check", true);
    	   return "product";

     }
      
     @RequestMapping("/catedit")  
     String catedit(@RequestParam("getcId")int id,Model l){
    	    	 
    	 l.addAttribute("CatModel",c.showone(id));
    	 l.addAttribute("CatTable",c.showAll());
    	 l.addAttribute("check", true);
    	   return "category";

     }

     
     @RequestMapping(value="/updatecat")
 	String updatecat(@Valid @ModelAttribute("CatModel") category o, BindingResult br, Model M) 
 	{
 		System.out.println("welcome");
 		if (br.hasErrors()) 
 		{
 			System.out.println(br.getAllErrors());
 			M.addAttribute("CatModel", o);
 			M.addAttribute("CatTable",c.showAll());
 			return "category";
 		} 
 		else
 		{
 			if (c.update(o))
 				return "redirect:/category";
 			else
 			{
 				System.out.println("error because backend");
 				M.addAttribute("CatModel", o);
 				M.addAttribute("CatTable",c.showAll());
 				return "category";
 			}
 		}

 	}
     @RequestMapping("/updateproduct")
 	String updateproduct(@Valid @ModelAttribute("ProModel") product k, BindingResult br, Model M) 
 	{
 		System.out.println("welcome");
 		if (br.hasErrors()) 
 		{
 			System.out.println(br.getAllErrors());
 			M.addAttribute("ProModel", k);
 			M.addAttribute("ProTable",p.showAll());
 			return "product";
 		} 
 		else
 		{

 			if (p.insert(k))
 					return "redirect:/product";
 			else
 			{
 				System.out.println("error because backend");
 				M.addAttribute("ProModel", k);
 				M.addAttribute("ProTable",p.showAll());
 				return "product";
 			}
 		}
 	}
     @RequestMapping(value={"/login"},method=RequestMethod.GET)
     public String loginCont(@RequestParam("email") String userid,@RequestParam("password")String pass)
     {   
    	 System.out.print(userid);
    	 System.out.print(pass);
    	 List<Register> allUser=d.showAll();
    	 Boolean userExist=false;
    	 for(Register reg:allUser)
    	 {
    		 if(reg.getEmail().equals(userid)&&reg.getUpassword().equals(pass))
    		 {
    			 userExist=true;
    		 }
    	 }
    	 if(userExist)
    	 {
    		 System.out.println("welcome mr./mrs."+userid);
    		 return "index";
    	 }
    	 else
    	 {
    			
    	     return "log";
    	
         }
     }
}
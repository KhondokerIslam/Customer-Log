package com.example.fullfledgeuserlogin;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/index")
public class UserInfoController {

    @Autowired
    UserInfoRepository userInfoRepository;


    @RequestMapping("/home")
    public String index(){
        return "index";
    }

    @GetMapping("/add")
    public String getUserAdd(Model model){
        UserInfo userInfo = new UserInfo();
//        List<String> qualification = new ArrayList<String>();
//        qualification.add("BSc");
//        qualification.add("Masters");
//        qualification.add("School");
//        qualification.add("College");
//        qualification.add("PHD");

        model.addAttribute("userInfo", userInfo);
        return "viewAdd";
    }
    @PostMapping("/add")
    public String postUserAdd(Model model, UserInfo userInfo){
        try {
            if (userInfo.getId() != null) {
                UserInfo oldUserInfo = userInfoRepository.findById(userInfo.getId()).get();
                oldUserInfo.setAboutMe(userInfo.getAboutMe());
                oldUserInfo.setAgeRange(userInfo.getAgeRange());
                oldUserInfo.setGender(userInfo.getGender());
                oldUserInfo.setQualification(userInfo.getQualification());
                oldUserInfo.setName(userInfo.getName());
                oldUserInfo.setDateOfBirth(userInfo.getDateOfBirth());
                userInfoRepository.save(oldUserInfo);

            } else {
                userInfoRepository.save(userInfo);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return "redirect:/index/home";
    }

    @GetMapping("/edit")
    public String showEdit(Model model){
        List<UserInfo> userInfo = userInfoRepository.findAll();

        model.addAttribute("userInfo", userInfo);
        return "viewEdit";
    }

    @GetMapping("/edit/{id}")
    public String editUserInfo(Model model, @PathVariable ("id") Integer id){
        Optional<UserInfo> userInfo = userInfoRepository.findById(id);
        model.addAttribute("userInfo", userInfo.get());

        return "viewAdd";
    }




}

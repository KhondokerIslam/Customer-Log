package com.example.fullfledgeuserlogin;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/index")
public class UserInfoController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/home")
    public String index(){
        return "index";
    }

    @GetMapping("/add")
    public String getUserAdd(Model model){
        UserInfo userInfo = new UserInfo();

        model.addAttribute("userInfo", userInfo);
        return "viewAdd";
    }
    @PostMapping("/add")
    public String postUserAdd(Model model, UserInfo userInfo){
        try {
            if (userInfo.getId() != null) {
                UserInfo oldUserInfo = userService.findById(userInfo.getId()).get();
                oldUserInfo.setAboutMe(userInfo.getAboutMe());
                oldUserInfo.setAgeRange(userInfo.getAgeRange());
                oldUserInfo.setGender(userInfo.getGender());
                oldUserInfo.setQualification(userInfo.getQualification());
                oldUserInfo.setName(userInfo.getName());
                oldUserInfo.setDateOfBirth(userInfo.getDateOfBirth());
                userService.save(oldUserInfo);

            } else {
//                userInfoRepository.save(userInfo);
                userService.save(userInfo);
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
//        List<UserInfo> userInfo = userInfoRepository.findAll();
        List<UserInfo> userInfo = userService.findAll();


        model.addAttribute("userInfo", userInfo);
        return "viewEdit";
    }

    @RequestMapping(value = "/fetch-user-data", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Wrapper> listUserInfo() {

        List<UserInfo> returningData = userInfoRepository.findAll();
        Wrapper w = new Wrapper(returningData,10, 3,10);

        return new ResponseEntity<>(w, HttpStatus.OK);
    }



    @GetMapping("/edit/{id}")
    public String editUserInfo(Model model, @PathVariable ("id") Integer id){
//        Optional<UserInfo> userInfo = userInfoRepository.findById(id);
        Optional<UserInfo> userInfo = userService.findById(id);
        model.addAttribute("userInfo", userInfo.get());

        return "viewAdd";
    }




}

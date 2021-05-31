package com.example.fullfledgeuserlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserInfoRepository userInfoRepository;

    public List<UserInfo> findAll(){
        return userInfoRepository.findAll();
    }

    @Transactional
    public void save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    public Optional<UserInfo> findById(Integer id){
        return userInfoRepository.findById(id);
    }





}

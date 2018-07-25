package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liukai on 2018/7/24.
 */
@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admin findByName(String name){
        return adminMapper.findByName(name);
    }
}

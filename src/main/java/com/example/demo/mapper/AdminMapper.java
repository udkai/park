package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liukai on 2018/7/24.
 */
@Mapper
public interface AdminMapper {
    @Select("select * from admin where name=#{name}")
    public Admin findByName(String name);
    @Select("select * from admin")
    public List<Admin> findAll();
}

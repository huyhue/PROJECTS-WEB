package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.ItemsUsers;

@Mapper
public interface ItemsUsersMapper {
	List<ItemsUsers> selectCommon();
}

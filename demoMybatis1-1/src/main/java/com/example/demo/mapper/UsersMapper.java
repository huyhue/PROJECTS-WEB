package com.example.demo.mapper;

import com.example.demo.model.Users;
import com.example.demo.model.UsersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	long countByExample(UsersExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int deleteByExample(UsersExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int insert(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int insertSelective(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	List<Users> selectByExample(UsersExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	Users selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int updateByPrimaryKeySelective(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated  Wed Jun 02 16:06:48 ICT 2021
	 */
	int updateByPrimaryKey(Users record);
	//custom  query
	List<Map<String, Object>> getAllUser(String name);
	List<Map<String, Object>> getAllUser1(Map<String, Object> param);
}
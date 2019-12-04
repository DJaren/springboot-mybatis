package com.example.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.mapper.cluster.ClusterUserMapper;
import com.example.test.mapper.master.MasterUserMapper;
import com.example.test.model.UserModel;

import javax.annotation.Resource;

/**
 * 用户控制层
 * @日期： 2018年7月5日 下午11:18:04
 * @作者： Chendb
 */
@RestController
public class UserController {

    @Resource
    private MasterUserMapper masterUserMapper;

    @Resource
    private ClusterUserMapper clusterUserMapper;

    /************************主库控制层接口-start******************************/
    @RequestMapping("user/getAllMaster")
    public List<UserModel> getAllMaster() {
        return masterUserMapper.getAll();
    }

    @RequestMapping("user/getMaster")
    public UserModel getUserMaster(Integer userId) {
        return masterUserMapper.get(userId);
    }

    @RequestMapping("user/insertMaster")
    public Integer insertMaster(UserModel userModel) {
        masterUserMapper.insert(userModel);
        // 必须使用对象获取id，否则无法获取到主键，而是获取到0（插入失败）或者1（插入成功）
        return userModel.getUserId();
    }

    @RequestMapping("user/updateMaster")
    public Integer updateMaster(UserModel userModel) {
        return masterUserMapper.update(userModel);
    }

    @RequestMapping("user/deleteMaster")
    public Integer deleteMaster(Integer userId) {
        return masterUserMapper.delete(userId);
    }
    /************************主库控制层接口-end******************************/

    /************************从库控制层接口-start******************************/
    @RequestMapping("user/getAllCluster")
    public List<UserModel> getAllCluster() {
        return clusterUserMapper.getAll();
    }

    @RequestMapping("user/getCluster")
    public UserModel getUserCluster(Integer userId) {
        return clusterUserMapper.get(userId);
    }

    @RequestMapping("user/insertCluster")
    public Integer insertCluster(UserModel userModel) {
        clusterUserMapper.insert(userModel);
        // 必须使用对象获取id，否则无法获取到主键，而是获取到0（插入失败）或者1（插入成功）
        return userModel.getUserId();
    }

    @RequestMapping("user/updateCluster")
    public Integer updateCluster(UserModel userModel) {
        return clusterUserMapper.update(userModel);
    }

    @RequestMapping("user/deleteCluster")
    public Integer deleteCluster(Integer userId) {
        return clusterUserMapper.delete(userId);
    }

}
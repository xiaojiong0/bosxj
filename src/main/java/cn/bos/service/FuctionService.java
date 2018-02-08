package cn.bos.service;

import cn.bos.domain.po.AuthFunction;
import cn.bos.domain.uipojo.EasyUIDataGridResult;

import java.util.List;
import java.util.Map;

public interface FuctionService {

    EasyUIDataGridResult pageQuery(Integer page, Integer rows);

    List<Map<String,String>> queryAll();

    int insert(AuthFunction authFunction);

    int deleteFuctions(String ids);
}

package cn.bos.service.impl;

import cn.bos.domain.po.AuthFunction;
import cn.bos.domain.uipojo.EasyUIDataGridResult;
import cn.bos.mapper.AuthFunctionMapper;
import cn.bos.service.FuctionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FuctionServiceImpl implements FuctionService {
    @Autowired
    AuthFunctionMapper fuctionMapper;


    @Override
    public EasyUIDataGridResult pageQuery(Integer page, Integer row) {
        PageHelper.startPage(page, row);
        List<AuthFunction> list = fuctionMapper.select(new AuthFunction());
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setRows(list);
        PageInfo<AuthFunction> pageInfo=new PageInfo<AuthFunction>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public List<Map<String, String>> queryAll() {
        List<AuthFunction> list = fuctionMapper.select(new AuthFunction());
        List<Map<String, String>> l=new ArrayList<Map<String, String>>();
        for (AuthFunction authFunction : list) {
            Map<String,String> map= new HashMap<String,String>();
            map.put("id",authFunction.getId()+"");
            map.put("info",authFunction.getName());
            map.put("name",authFunction.getName());
            map.put("pId",authFunction.getPid());
            l.add(map);
        }

        return l;
    }

    @Override
    public int insert(AuthFunction authFunction) {

        int i = fuctionMapper.insert(authFunction);
        System.out.println("功能返回："+i);
        return 0;
    }

    @Override
    public int deleteFuctions(String ids) {
        ids=ids.substring(0,ids.length()-1);
        int i = fuctionMapper.bachDeleteids(ids);
        return i;
    }
}

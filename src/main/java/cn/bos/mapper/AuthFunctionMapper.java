package cn.bos.mapper;

import cn.bos.domain.po.AuthFunction;
import com.github.abel533.mapper.Mapper;

public interface AuthFunctionMapper extends Mapper<AuthFunction> {

    int bachDeleteids(String ids);
}

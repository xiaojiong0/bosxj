package cn.bos.comfig;

import cn.bos.domain.po.Item;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//SpringMVC多视图支持配置
//@Configuration
public class springMVCmuiltConfig {


//    @Bean
    //boss
    public ContentNegotiatingViewResolver ContentNegotiatingViewResolver(){
        Jaxb2Marshaller j=new Jaxb2Marshaller();
        j.setClassesToBeBound(Item.class);
        ContentNegotiationManagerFactoryBean cnmf=new ContentNegotiationManagerFactoryBean();
        Properties properties = new Properties();
        properties.put("json","application/json");
        properties.put("xml","application/xml");
        cnmf.setMediaTypes(properties);
        ContentNegotiatingViewResolver c=new ContentNegotiatingViewResolver();
        ContentNegotiationManager contentNegotiationManager = cnmf.getObject();
        c.setContentNegotiationManager(contentNegotiationManager);
          List<View> list=new ArrayList<View>();
        list.add(new MappingJackson2JsonView());
        MarshallingView nsv=  new MarshallingView(j);
        list.add(nsv);
        c.setDefaultViews(list);
        return c;
    }
}

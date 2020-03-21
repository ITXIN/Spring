package com.agan.boot.utils;

import com.agan.boot.response.Result;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

    // 字符串转对象
   static public Object string2Object(String string){
        Object object = JSON.parseObject(string, Result.class);
        return object;
    }

   static public String object2Json(Object o) throws JsonProcessingException {
//        String string = JSON.toJSONString(o);
//        return string;
//       log.debug("--------object2json start");
//       log.debug(string);
//       log.debug("--------object2json end");
       ObjectMapper mapper = new ObjectMapper();
       String jsonInString = mapper.writeValueAsString(o);
       return  jsonInString;
    }
}

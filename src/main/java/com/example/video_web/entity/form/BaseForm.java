package com.example.video_web.entity.form;

import com.example.video_web.entity.po.BasePo;
import org.springframework.beans.BeanUtils;

public class BaseForm<T extends BasePo> {

    /**
     * Form转化为Po，进行后续业务处理
     *
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        return t;
    }
}

package com.backendlist.RedisSeckill.mapper;


import com.backendlist.RedisSeckill.domain.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;

/**
* @author kj
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2023-05-02 21:01:11
* @Entity generator.domain.Goods
*/
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Update("UPDATE goods SET repertory=repertory-1 WHERE id =1 AND repertory>0")
    public void updateRepertory();

    @Update("UPDATE goods SET repertory=repertory+1 WHERE id =1 AND repertory>0")
    public void addRepertory();
}





package com.qingfeng.fm.service.impl;

import com.qingfeng.fm.dao.IndexImgMapper;
import com.qingfeng.fm.entity.IndexImg;
import com.qingfeng.fm.service.IndexImgService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图业务的实现
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/11/23
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    /**
     * 查询轮播图信息
     * @return
     */
    @Override
    public ResultVO listIndexImgs() {
        //调用持久层，查询轮播图信息
        List<IndexImg> indexImgs = indexImgMapper.listIndexImgs();
        //容错检查
        if (indexImgs.size() == 0) {
            return new ResultVO(ResStatus.NO,"fail",null);
        }else {
            return new ResultVO(ResStatus.OK,"success",indexImgs);
        }
    }
}

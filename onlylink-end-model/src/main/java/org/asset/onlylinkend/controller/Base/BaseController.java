package org.asset.onlylinkend.controller.Base;

import org.asset.onlylinkend.entity.dto.user;
import org.asset.onlylinkend.entity.vo.ResponseVO;
import org.asset.onlylinkend.entity.constant.Constants;
import org.asset.onlylinkend.entity.enums.ResponseCodeEnum;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class BaseController {


    public <T> ResponseVO getSuccessResponseVO(T t) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setStatus(Constants.STATUC_SUCCESS);
        responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_200.getMsg());
        responseVO.setData(t);
        return responseVO;
    }

//    protected <S, T> PaginationResultVO<T> convert2PaginationVO(PaginationResultVO<S> result, Class<T> classz) {
//        PaginationResultVO<T> resultVO = new PaginationResultVO<>();
//        resultVO.setList(CopyTools.copyList(result.getList(), classz));
//        resultVO.setPageNo(result.getPageNo());
//        resultVO.setPageSize(result.getPageSize());
//        resultVO.setPageTotal(result.getPageTotal());
//        resultVO.setTotalCount(result.getTotalCount());
//        return resultVO;
//    }


    protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public user getUserInfoFromSession(HttpSession session) {
        user sessionWebUserDto = (user) session.getAttribute(Constants.SESSION_KEY);
        return sessionWebUserDto;
    }
}

package com.lanswon.core.mapper;

import com.lanswon.core.bean.dto.QueryRecordDTO;
import com.lanswon.core.bean.po.*;
import com.lanswon.core.bean.pojo.RecordLoad;
import com.lanswon.core.bean.pojo.RecordPay;
import com.lanswon.core.bean.pojo.RecordRefund;
import com.lanswon.core.bean.vo.RecordEntityVo;
import com.lanswon.core.bean.vo.StatementCountVO;
import com.lanswon.core.bean.vo.StatementVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 记录dao
 *
 * @author Jaswine
 */
@Repository
public interface RecordMapper {

	/**
	 * 消费记录
	 * @param payRecord 消费实体
	 * @return true or false
	 */
	boolean addPayRecord(@Param("payRecord") RecordPay payRecord);

	/**
	 * 充值记录
	 * @param recordLoad 充值实体
	 * @return true or false
	 */
	boolean addLoadRecord(@Param("recordLoad") RecordLoad recordLoad);

	/**
	 * 退费记录
	 * @param refundRecord 退费申请实体
	 * @return true or false
	 */
	boolean addRefundRecordDao(@Param("refundRecord") RecordRefund refundRecord);

	//////////////流水RECORD////////////

	/**
	 * 获得所有消费记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	List<StatementVO> getAllPayRecordInfo(@Param("queryRecordDTO") QueryRecordDTO queryRecordDTO);

	/**
	 * 获得所有充值记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	List<StatementVO> getAllLoadRecordInfo(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);

	/**
	 * 获得所有退费记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	List<StatementVO> getAllRefundRecordInfo(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);

	/**
	 * 获得所有记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	List<StatementVO> getAllRecordInfo(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);

	/**
	 * 记录统计
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	List<StatementCountVO> getRecordCount(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);


	////////////报表REPORT////////////
	/**
	 * deviceId-->消费日报
	 * @param deviceid 设备id
	 * @return res
	 */
	PayInfoPO getDailyPayInfoByDeviceId(String deviceid);

	/**
	 * deviceId-->消费月报
	 * @param deviceid 设备id
	 * @return res
	 */
	PayInfoPO getMonthlyPayInfoByDeviceId(String deviceid);

	/**
	 * deviceId-->消费年报
	 * @param deviceid 设备id
	 * @return res
	 */
	List<PayInfoPO> getYearPayInfoByDeviceId(String deviceid);

	/**
	 * 现金-->日充值
	 * @return money
	 */
	double getDailyLoadCountByCash();

	/**
	 * 微信-->日充值
	 * @return money
	 */
	double getDailyLoadCountByWechat();

	/**
	 * 支付宝-->日充值
	 * @return money
	 */
	double getDailyLoadCountByAlipay();

	/**
	 * 现金-->月充值
	 * @return money
	 */
	double getMonthlyLoadCountByCash();

	/**
	 * 微信-->月充值
	 * @return money
	 */
	double getMonthlyLoadCountByWechat();

	/**
	 * 支付宝-->月充值
	 * @return money
	 */
	double getMonthlyLoadCountByAlipay();

	/**
	 * 现金-->年充值
	 * @return money
	 */
	double getYearLoadCountByCash();

	/**
	 * 微信-->年充值
	 * @return money
	 */
	double getYearLoadCountByWechat();

	/**
	 * 支付宝-->年充值
	 * @return money
	 */
	double getYearLoadCountByAlipay();

	/////////////报表COUNT/////////////

	/**
	 * 日充值统计
	 * @return res
	 */
	LoadReportDetailPO getDailyLoadCount();

	/**
	 * 月充值统计
	 * @return res
	 */
	LoadReportDetailPO getMonthlyLoadCount();

	/**
	 * 年充值统计
	 * @return res
	 */
	List<LoadReportDetailPO>  getYearLoadCount();

	LoadInfo getDailyLoadInfoByMoneyType(int i);

	LoadInfo getMonthlyLoadInfoByMoneyType(int i);

	LoadInfo getYearLoadInfoByMoneyType(@Param("i")int i,@Param("months")String months);

	RecordRefund getRefRefundRecordByAcctId(String acctId);

	RefundReportPO getDailyReqRefundCount();

	int getDailyConfirmRefund();

	double getDailyHaveRefunMoney();

	int getDailyConfirmRefundTicket();

	RefundReportPO getMonthlyReqRefundCount();

	int getMonthlyConfirmRefund();

	double getMonthlyHaveRefunMoney();

	int getMonthlyConfirmRefundTicket();

	List<RefundReportPO> getYearReqRefundCount();

	int getYearConfirmRefund(String months);

	double getYearHaveRefunMoney(String months);

	int getYearConfirmRefundTicket(String months);

	List<RecordEntityVo> getAllPayRecordVoInfo(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);

	List<RecordEntityVo> getAllLoadRecordVoInfo(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);

	List<RecordEntityVo> getAllRefundRecordVoInfo(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);

	List<RecordEntityVo> getAllRecordVoInfo(@Param("queryRecordDTO")QueryRecordDTO queryRecordDTO);

	List<LoadDetail> DailyLoadDeatil();

	List<PayDetail> PayDetail();

	List<RefundDetail> refundDetail();

}

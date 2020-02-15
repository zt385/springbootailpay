package com.zt.ailpayspringboot.service.imp;

import java.util.Date;



import com.zt.ailpayspringboot.common.Sid;
import com.zt.ailpayspringboot.mapper.FlowMapper;
import com.zt.ailpayspringboot.mapper.OrdersMapper;
import com.zt.ailpayspringboot.pojo.Flow;
import com.zt.ailpayspringboot.pojo.Orders;
import com.zt.ailpayspringboot.service.OrdersService;
import com.zt.ailpayspringboot.utils.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersMapper ordersMapper;
	
	@Resource
	private FlowMapper flowMapper;
	
	@Autowired
	private Sid sid;
	
	@Override
	public void saveOrder(Orders order) {
		ordersMapper.insert(order);
	}

	@Override
	public Orders getOrderById(String orderId) {
		return ordersMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount) {
		
		Orders order = getOrderById(orderId);
		if (order.getOrderStatus().equals(OrderStatusEnum.WAIT_PAY.key)) {
			order = new Orders();
			order.setId(orderId);
			order.setOrderStatus(OrderStatusEnum.PAID.key);
			order.setPaidTime(new Date());
			order.setPaidAmount(paidAmount);
			
			ordersMapper.updateByPrimaryKeySelective(order);
			
			order = getOrderById(orderId);
			
			String flowId = sid.nextShort();
			Flow flow = new Flow();
			flow.setId(flowId);
			flow.setFlowNum(alpayFlowNum);
			flow.setBuyCounts(order.getBuyCounts());
			flow.setCreateTime(new Date());
			flow.setOrderNum(orderId);
			flow.setPaidAmount(paidAmount);
			flow.setPaidMethod(1);
			flow.setProductId(order.getProductId());
			
			flowMapper.insertSelective(flow);
		}
		
	}

}

package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.dao.api.filter.OrderHistoryFilter;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.service.IOrderHistoryService;
import com.itacademy.jd2.is.carsharing.web.converter.OrderHistoryFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.OrderHistoryToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.OrderHistoryDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;

@Controller
public class OrderController extends AbstractController<OrderHistoryDTO> {

	private final IOrderHistoryService orderHistoryService;
	private final OrderHistoryFromDTOConverter orderFromDtoConverter;
	private final OrderHistoryToDTOConverter orderToDtoConverter;
	private final ICarService carService;
	private final ICustomerService customerService;

	@Autowired
	public OrderController(IOrderHistoryService orderHistoryService, OrderHistoryFromDTOConverter orderFromDtoConverter,
			OrderHistoryToDTOConverter orderToDtoConverter, ICarService carService, ICustomerService customerService) {
		super();
		this.orderHistoryService = orderHistoryService;
		this.orderFromDtoConverter = orderFromDtoConverter;
		this.orderToDtoConverter = orderToDtoConverter;
		this.carService = carService;
		this.customerService = customerService;
	}

	@RequestMapping(value = "/order", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {
		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final OrderHistoryFilter filter = new OrderHistoryFilter();

		prepareFilter(gridState, filter);

		final List<IOrderHistory> entities = orderHistoryService.find(filter);
		final List<OrderHistoryDTO> dtos = entities.stream().map(orderToDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(orderHistoryService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);

		return new ModelAndView("order.list", models);
	}

	@RequestMapping(value = "/car/{id}/order/", method = RequestMethod.GET)
	public ModelAndView viewOrderForm(@PathVariable(name = "id", required = true) final Integer id) {
		final IOrderHistory dbModel = orderHistoryService.getFullInfo(id);
		final OrderHistoryDTO dto = orderToDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("order", hashMap);
	}

//	@RequestMapping(value = "/car/{id}/order", method = RequestMethod.POST)
//	public Object makeOrder(@PathVariable(name = "id", required = true) final Integer id,
//			@Valid @ModelAttribute("formModel") final OrderHistoryDTO formModel, final BindingResult result) {
//
//		if (result.hasErrors()) {
//			final Map<String, Object> hashMap = new HashMap<>();
//			hashMap.put("formModel", formModel);
//			return new ModelAndView("order", hashMap);
//		} else {
//			final IOrderHistory entity = orderFromDtoConverter.apply(formModel);
//			orderHistoryService.save(entity);
//			return "redirect:/car";
//		}
//	}

}

package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CustomerFilter;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.BrandDTO;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends AbstractController<CustomerDTO>{
	
	private final ICustomerService customerService;
	
	private final CustomerToDTOConverter toDtoConverter;
	
	@Autowired
	public CustomerController(ICustomerService customerService, CustomerToDTOConverter toDtoConverter,
			CustomerFromDTOConverter fromDtoConverter) {
		super();
		this.customerService = customerService;
		this.toDtoConverter = toDtoConverter;
	}
	
    @InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		final StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
    
    @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView index(final HttpServletRequest req,
            @RequestParam(name = "page", required = false) final Integer pageNumber,
            @RequestParam(name = "sort", required = false) final String sortColumn) {
        final GridStateDTO gridState = getListDTO(req);
        gridState.setPage(pageNumber);
        gridState.setSort(sortColumn, "id");

        final CustomerFilter filter = new CustomerFilter();
        prepareFilter(gridState, filter);

        final List<ICustomer> entities = customerService.find(filter);
        final List<CustomerDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
        gridState.setTotalCount(customerService.getCount(filter));

        final Map<String, Object> models = new HashMap<>();
        models.put("gridItems", dtos);
        return new ModelAndView("customer.list", models);
    }
    
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        customerService.delete(id);
        return "redirect:/customer";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
        final ICustomer dbModel = customerService.get(id);
        final CustomerDTO dto = toDtoConverter.apply(dbModel);
        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("customer.edit", hashMap);
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
        final CustomerDTO dto = toDtoConverter.apply(customerService.get(id));

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", dto);

        return new ModelAndView("customer.edit", hashMap);
    }
	
	

}

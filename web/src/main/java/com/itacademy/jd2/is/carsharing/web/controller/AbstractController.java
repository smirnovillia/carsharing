package com.itacademy.jd2.is.carsharing.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.itacademy.jd2.is.carsharing.dao.api.filter.AbstractFilter;
import com.itacademy.jd2.is.carsharing.web.dto.list.ListDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.SortDTO;

public class AbstractController<DTO> {
	protected ListDTO<DTO> getListDTO(final HttpServletRequest req) {
		final String sessionModelName = getClass().getSimpleName() + "_LIST_MODEL";

		ListDTO<DTO> listModel = (ListDTO<DTO>) req.getSession().getAttribute(sessionModelName);
		if (listModel == null) {
			listModel = new ListDTO<DTO>();
			req.getSession().setAttribute(sessionModelName, listModel);
		}
		return listModel;
	}

	protected void prepareFilter(ListDTO<DTO> listDTO, AbstractFilter filter) {
		filter.setLimit(listDTO.getItemsPerPage());
		int offset = listDTO.getItemsPerPage() * (listDTO.getPage() - 1);
		filter.setOffset(listDTO.getTotalCount() < offset ? 0 : offset);

		final SortDTO sortModel = listDTO.getSort();
		if (sortModel != null) {
			filter.setSortColumn(sortModel.getColumn());
			filter.setSortOrder(sortModel.isAscending());
		}
	}
}

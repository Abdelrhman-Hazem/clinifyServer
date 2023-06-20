package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.entities.BaseEntity;
import gov.iti.jets.clinify.services.BaseServiceImp;
import gov.iti.jets.clinify.utils.MessageResponse;
import gov.iti.jets.clinify.utils.PageQueryUtil;
import gov.iti.jets.clinify.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
public class BaseController<E extends BaseEntity, D extends BaseDto>{

	@Autowired
	private BaseServiceImp<E, D> baseService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public D get(@PathVariable(value = "id") Integer id) {
		return baseService.findById(id);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public List<D> list() {
		return baseService.findAll();
	}
	@RequestMapping(value="/getPage", method = RequestMethod.GET)
	public PageResult<D> getDataPage(@RequestParam int page, @RequestParam int limit) {
		PageQueryUtil queryUtil = new PageQueryUtil(page, limit);
		return baseService.getDataPage(queryUtil);
	}
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public MessageResponse create(@RequestBody D dto) {
		 baseService.save(dto);
		 return new MessageResponse("Item has been saved successfully");
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<D> update(@RequestBody D dto) {

		 return new ResponseEntity<>(baseService.save(dto), HttpStatus.OK);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public MessageResponse delete(@PathVariable(value = "id") Integer id) {
		baseService.deleteById(id);
		return new MessageResponse("Item has been deleted successfully");
	}
}

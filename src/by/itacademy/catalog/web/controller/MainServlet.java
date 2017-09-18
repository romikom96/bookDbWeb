package by.itacademy.catalog.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.service.CatalogService;
import by.itacademy.catalog.service.impl.SimpleCatalogImpl;
import by.itacademy.catalog.web.command.ActionType;
import by.itacademy.catalog.web.command.BasicAction;
import by.itacademy.catalog.web.command.CommandChooser;

public class MainServlet extends HttpServlet {

	@SuppressWarnings("unused")
	private CatalogService service;

	private int requestCount = 0;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("Service method: " + requestCount);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destroy method: " + requestCount);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init method: " + requestCount);

		service = new SimpleCatalogImpl();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		requestCount++;

		String command = request.getParameter("command");
		System.out.println(command);

		ActionType action = ActionType.valueOf(command.toUpperCase());

		BasicAction basicAction = CommandChooser.performAction(action);
		basicAction.executeAction(request, response);

	}

}
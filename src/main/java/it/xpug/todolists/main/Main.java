package it.xpug.todolists.main;


import static java.lang.Integer.*;
import it.xpug.toolkit.web.*;


public class Main {
	public static void main(String[] args) {
		String port = System.getenv("PORT");
		if (port == null || port.isEmpty()) {
			port = "8080";
		}

		TodoListRepository todoLists = new InMemoryTodoListRepository();
		ReusableJettyApp app = new ReusableJettyApp(new TodoListsServlet(todoLists));
		app.start(valueOf(port), "src/main/webapp");
	}
}

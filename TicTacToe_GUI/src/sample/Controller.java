package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.TTT.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import players.*;

public class Controller {
	private Service<Void> backgroundThread;
	private Button[] buttons = new Button[9];
	public TTT game = new TTT();
	private int number = 1;
	public char firstMark = '_';
	public int firstType = -1;
	public int secondType = -1;

	@FXML
	public Text end;
	@FXML
	public Button markX;
	@FXML
	public Button markO;
	@FXML
	public Button human1;
	@FXML
	public Button easy1;
	@FXML
	public Button middle1;
	@FXML
	public Button hard1;
	@FXML
	public Button human2;
	@FXML
	public Button easy2;
	@FXML
	public Button middle3;
	@FXML
	public Button hard2;
	@FXML
	public Button temp;
	@FXML
	public Button but11;
	@FXML
	public Button but01;
	@FXML
	public Button but21;
	@FXML
	public Button but00;
	@FXML
	public Button but10;
	@FXML
	public Button but20;
	@FXML
	public Button but22;
	@FXML
	public Button but12;
	@FXML
	public Button but02;

	public void printX(int iter) {
		backgroundThread = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {

						//game.menu();

						updateMessage("X");
						return null;
					}
				};
			}
		};

		backgroundThread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent workerStateEvent) {
				System.out.println("ChetoRabotaet");
			}
		});

		buttons[iter].textProperty().bind(backgroundThread.messageProperty());

		backgroundThread.restart();
	}
	public void printO(int iter) {
		backgroundThread = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {

						//game.menu();

						updateMessage("O");
						return null;
					}
				};
			}
		};

		backgroundThread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent workerStateEvent) {
				System.out.println("ChetoRabotaet");
			}
		});

		buttons[iter].textProperty().bind(backgroundThread.messageProperty());

		backgroundThread.restart();
	}

	public void initialize() {
		buttons[0] = but00;
		buttons[1] = but01;
		buttons[2] = but02;
		buttons[3] = but10;
		buttons[4] = but11;
		buttons[5] = but12;
		buttons[6] = but20;
		buttons[7] = but21;
		buttons[8] = but22;

		markX.setOnAction(event -> {
			markX.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					firstMark = 'X';
				}
			});
		});

		markO.setOnAction(event -> {
			markO.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					firstMark = 'O';
				}
			});
		});

		human1.setOnAction(event -> {
			human1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					firstType = 0;
				}
			});
		});

		easy1.setOnAction(event -> {
			easy1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					firstType = 1;
				}
			});
		});

		middle1.setOnAction(event -> {
			middle1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					firstType = 2;
				}
			});
		});

		hard1.setOnAction(event -> {
			hard1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					firstType = 3;
				}
			});
		});

		human2.setOnAction(event -> {
			human2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					secondType = 0;
				}
			});
		});

		easy2.setOnAction(event -> {
			easy2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					secondType = 1;
				}
			});
		});

		middle3.setOnAction(event -> {
			middle3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					secondType = 2;
				}
			});
		});

		hard2.setOnAction(event -> {
			hard2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					secondType = 3;
				}
			});
		});
	}

	public void startDesktop() {

		new Thread(() -> {
			if (firstMark == 'X') {
				if (firstType == 0) {
					game.player1 = new Human('X');
					if (secondType == 0) {
						game.player2 = new Human('O');
					}
					if (secondType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (secondType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (secondType == 3) {
						game.player2 = new HardBot('O');
					}
				}
				if (firstType == 1) {
					game.player1 = new BotRandom('X');
					if (secondType == 0) {
						game.player2 = new Human('O');
					}
					if (secondType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (secondType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (secondType == 3) {
						game.player2 = new HardBot('O');
					}
				}
				if (firstType == 2) {
					game.player1 = new GreedyBot('X');
					if (secondType == 0) {
						game.player2 = new Human('O');
					}
					if (secondType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (secondType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (secondType == 3) {
						game.player2 = new HardBot('O');
					}
				}
				if (firstType == 3) {
					game.player1 = new HardBot('X');
					if (secondType == 0) {
						game.player2 = new Human('O');
					}
					if (secondType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (secondType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (secondType == 3) {
						game.player2 = new HardBot('O');
					}
				}
			}

			if (firstMark == 'O') {
				if (secondType == 0) {
					game.player1 = new Human('X');
					if (firstType == 0) {
						game.player2 = new Human('O');
					}
					if (firstType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (firstType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (firstType == 3) {
						game.player2 = new HardBot('O');
					}
				}
				if (secondType == 1) {
					game.player1 = new BotRandom('X');
					if (firstType == 0) {
						game.player2 = new Human('O');
					}
					if (firstType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (firstType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (firstType == 3) {
						game.player2 = new HardBot('O');
					}
				}
				if (secondType == 2) {
					game.player1 = new GreedyBot('X');
					if (firstType == 0) {
						game.player2 = new Human('O');
					}
					if (firstType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (firstType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (firstType == 3) {
						game.player2 = new HardBot('O');
					}
				}
				if (secondType == 3) {
					game.player1 = new HardBot('X');
					if (firstType == 0) {
						game.player2 = new Human('O');
					}
					if (firstType == 1) {
						game.player2 = new BotRandom('O');
					}
					if (firstType == 2) {
						game.player2 = new GreedyBot('O');
					}
					if (firstType == 3) {
						game.player2 = new HardBot('O');
					}
				}
			}

			if (game.player1.type == "Human") {
				game.player1.desktop = true;
			}

			if (game.player2.type == "Human") {
				game.player2.desktop = true;
			}

			do {
				if (!game.player1.desktop) {
					game.stepX(number);
					printX(game.out);
				} else {
					but00.setOnAction(event -> {
						but00.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 0;
								game.player1.desktopY = 0;

							}
						});
					});

					but01.setOnAction(event -> {
						but01.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 0;
								game.player1.desktopY = 1;


							}
						});
					});

					but02.setOnAction(event -> {
						but02.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 0;
								game.player1.desktopY = 2;


							}
						});
					});

					but10.setOnAction(event -> {
						but10.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 1;
								game.player1.desktopY = 0;


							}
						});
					});

					but11.setOnAction(event -> {
						but11.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 1;
								game.player1.desktopY = 1;

							}
						});
					});

					but12.setOnAction(event -> {
						but12.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 1;
								game.player1.desktopY = 2;


							}
						});
					});

					but20.setOnAction(event -> {
						but20.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 2;
								game.player1.desktopY = 0;


							}
						});
					});

					but21.setOnAction(event -> {
						but21.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 2;
								game.player1.desktopY = 1;


							}
						});
					});

					but22.setOnAction(event -> {
						but22.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player1.desktopX = 2;
								game.player1.desktopY = 2;


							}
						});
					});

					game.stepX(number);
					printX(game.out);
				}


				if (!game.player2.desktop) {
					if (game.square.won != '_' && game.square.won != 'X' && game.square.won != 'O') {
						game.stepO(number);
						printO(game.out);
					}
				} else {
					but00.setOnAction(event -> {
						but00.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 0;
								game.player2.desktopY = 0;
							}
						});
					});

					but01.setOnAction(event -> {
						but01.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 0;
								game.player2.desktopY = 1;
							}
						});
					});

					but02.setOnAction(event -> {
						but02.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 0;
								game.player2.desktopY = 2;
							}
						});
					});

					but10.setOnAction(event -> {
						but10.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 1;
								game.player2.desktopY = 0;
							}
						});
					});

					but11.setOnAction(event -> {
						but11.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 1;
								game.player2.desktopY = 1;
							}
						});
					});

					but12.setOnAction(event -> {
						but12.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 1;
								game.player2.desktopY = 2;
							}
						});
					});

					but20.setOnAction(event -> {
						but20.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 2;
								game.player2.desktopY = 0;
							}
						});
					});

					but21.setOnAction(event -> {
						but21.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 2;
								game.player2.desktopY = 1;
							}
						});
					});

					but22.setOnAction(event -> {
						but22.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								game.player2.desktopX = 2;
								game.player2.desktopY = 2;
							}
						});
					});

					if (game.square.won != '_' && game.square.won != 'X' && game.square.won != 'O') {
						game.stepO(number);
						printO(game.out);
					}
				}
				number++;
			} while (game.square.won != '_' && game.square.won != 'X' && game.square.won != 'O');

			if (game.square.won != '_') {
				end.setText(game.square.won + " - WON");
			} else {
				end.setText("DRAW");
			}
			System.out.println("GAME END");
		}).start();
	}

}

package mvc.exam3;

public class CommandFactory {
	//객체 생성못하게 private로 생성자를 막음 -- 싱글톤
	private CommandFactory(){}
	private static CommandFactory instance = new CommandFactory();
	public static CommandFactory getInstance(){
		return instance;
	}
	public ICommand createComman(String cmd){
		if(cmd.equals("MAIN")){
			return new MainCommand();
			
		}
		else if (cmd.equals("REGFORM")){
			return new RegFormCommand();
			/*nextPage = (String)regCommand.processCommand(req, resp);*/
		
		}else  if(cmd.equals("REGCONFIRM")){
			//입력값 확인
			//입력값이 잘못되었을 경우 해당 에러페이지로 이동
			return new RegConfirmCommand();
		}
		else  if(cmd.equals("REGCOMPLETE")){
			return new RecCompletCommand();
			//db연동 데이터 저장
		}
		else if(cmd.equals("ZIPSEARCH")){
			return new ZipCommand();
		}
		else{
			return null;
		}
		
	}
}

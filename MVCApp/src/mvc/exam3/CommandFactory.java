package mvc.exam3;

public class CommandFactory {
	//��ü �������ϰ� private�� �����ڸ� ���� -- �̱���
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
			//�Է°� Ȯ��
			//�Է°��� �߸��Ǿ��� ��� �ش� ������������ �̵�
			return new RegConfirmCommand();
		}
		else  if(cmd.equals("REGCOMPLETE")){
			return new RecCompletCommand();
			//db���� ������ ����
		}
		else if(cmd.equals("ZIPSEARCH")){
			return new ZipCommand();
		}
		else{
			return null;
		}
		
	}
}

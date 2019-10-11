package pattern.behavioral.memento;

/**棋子客户端
 * @author zhiwei.liu003
 * @date 2019/10/1121:23
 */
public class Client {
    private static  int index = -1;
    private  static MementoCaretaker mc =new MementoCaretaker();

    public static void main(String args[]){
        Chessman chess = new Chessman("车",1,1);
        paly(chess);
        chess.setX(4);
        paly(chess);
        chess.setX(5);
        paly(chess);
        undo(chess,index);
        undo(chess,index);
        redo(chess,index);
        redo(chess,index);
    }



    /**
     * 下棋，同时保存备忘录
     * @param chess
     */
    private static void paly(Chessman chess) {
        mc.addMento(chess.save());
        index++;
        chess.show();
    }

    /**
     * 悔棋
     * @param chess
     * @param index
     */
    private static void undo(Chessman chess, int index) {
        System.out.println("***悔棋***");
        index--;
        chess.restore(mc.getMento(index-1));
        chess.show();
    }

    /**
     * 撤销悔棋，恢复到下一个备忘录
     * @param chess
     * @param index
     */
    private static void redo(Chessman chess, int index) {
        System.out.println("***撤销悔棋***");
        index++;
        chess.restore(mc.getMento(index+1));
        chess.show();
    }

}

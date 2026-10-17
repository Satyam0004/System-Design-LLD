//class JudgeAnalytics {
//    private static JudgeAnalytics judgeAnalytics;
//
//    private JudgeAnalytics() {
//    }
//
//    public static JudgeAnalytics getInstance() {
//        if (judgeAnalytics == null) {
//            judgeAnalytics = new JudgeAnalytics();
//        }
//        return judgeAnalytics;
//    }
//}
//
//public class LazyLoading {
//    public static void main(String[] args) {
//        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
//        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();
//        System.out.println(judgeAnalytics);
//        System.out.println(judgeAnalytics2);
//    }
//}

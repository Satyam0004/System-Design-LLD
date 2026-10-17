class EagerJudgeAnalytics {
    private static final EagerJudgeAnalytics eagerJudgeAnalytics = new EagerJudgeAnalytics();

    private EagerJudgeAnalytics() {

    }

    public static EagerJudgeAnalytics getInstance() {
        return eagerJudgeAnalytics;
    }
}

public class EagerLoading {
    public static void main(String []args) {
        EagerJudgeAnalytics eagerJudgeAnalytics = EagerJudgeAnalytics.getInstance();
        EagerJudgeAnalytics eagerJudgeAnalytics2 = EagerJudgeAnalytics.getInstance();

        System.out.println(eagerJudgeAnalytics);
        System.out.println(eagerJudgeAnalytics2);
    }
}

interface RecommendationStrategy {
    void recommendation();
}

class TrendingRecommendation implements RecommendationStrategy {
    public void recommendation() {

    }
}

class GenreRecommendation implements RecommendationStrategy {
    public void recommendation() {

    }
}

class RecentRecommendation implements RecommendationStrategy {
    public void recommendation() {

    }
}

class RecommendationAlgorithm {
    private RecommendationStrategy recommendationStrategy;
    public RecommendationAlgorithm(RecommendationStrategy recommendationStrategy) {
        this.recommendationStrategy = recommendationStrategy;
    }

    public void recommendation() {
        recommendationStrategy.recommendation();
    }
}

public class Main {
    public static void main(String[] args) {
        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(new TrendingRecommendation());
        recommendationAlgorithm.recommendation();
    }
}
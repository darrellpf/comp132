package bitsandpiecestwo;
public enum BallPurchase {
        
        NONE("No Purchase", 0, 0),
        
        ONE_FOR_FIVE("One for $5", 1, 5),
        THREE_FOR_TEN("Three for $10", 3, 10),
        FIVE_FOR_FIFTEEN("Five for $15", 5, 15);

        private final String dealName;
        private final int balls;
        private final int money;
        
        private BallPurchase(String inDealName, int inBalls, int inMoney) {
                dealName = inDealName;
                balls = inBalls;
                money = inMoney;
        }
        
        public String getDealName() {
                return dealName;
        }
        
        public int getBalls() {
                return balls;
        }
        
        public int getMoney() {
                return money;
        }
        
        public float getCostPerBall() {
                float moneyPaid = money;
                return moneyPaid / balls;
        }
}
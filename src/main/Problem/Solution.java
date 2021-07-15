class Solution {
    Object problem;
    int solutionNum;
    Solution(String problemId) throws Exception{
        Class clz = Class.forName("Problem"+problemId);
        this.problem = clz.newInstance();
        solutionNum = (int) clz.getField("solutionNum").get(this.problem);
        System.out.println("==============================");
        System.out.println("共有"+solutionNum+"个解法，请选择");
    }
    Solution(){

    }

    void run(String  solutionNum) throws Exception{
        System.out.println("==============================");
        System.out.println("运行结果为");
        problem.getClass().getMethod("solution" + solutionNum).invoke(problem);
    }
}

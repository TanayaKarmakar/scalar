package com.scalar.design.lld.lockermanagement.strategies;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class RandomOtpGenerator implements IOtpGeneratorStrategy {
  private final int otpLength;
  private final IRandomGenerator randomGenerator;

  public RandomOtpGenerator(int otpLength, IRandomGenerator randomGenerator) {
    this.otpLength = otpLength;
    this.randomGenerator = randomGenerator;
  }


  @Override
  public String generateOtp() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < otpLength; i++) {
      sb.append(randomGenerator.getRandomNumber(10));
    }
    return sb.toString();
  }
}

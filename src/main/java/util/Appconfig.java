package util;

import member.*;

public class Appconfig {
    public GeneralMemberService generalMemberService(){
        return new GeneralServiceImpl(generalMemberRepository());
    }
    public static GeneralMemberRepository generalMemberRepository(){
        return new GeneralMemoryRepository();

    }
    public SavingsMemberService savingsMemberService(){
        return new SavingsServiceImpl(savingsMemberRepository());
    }
    public static SavingsMemberRepository savingsMemberRepository(){
        return new SavingsMemoryRepository();

    }
}

package util;

import member.*;

public class Appconfig {
    public MemberService generalMemberService(){
        return new GeneralServiceImpl(generalMemberRepository());
    }
    public static MemberRepository generalMemberRepository(){
        return new MemoryRepository();

    }
}

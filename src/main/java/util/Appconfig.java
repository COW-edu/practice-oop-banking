package util;

import member.*;

public class Appconfig {
    public MemberService memberService(){
        return new ServiceImpl(generalMemberRepository());
    }
    public static MemberRepository generalMemberRepository(){
        return new MemoryRepository();

    }
}

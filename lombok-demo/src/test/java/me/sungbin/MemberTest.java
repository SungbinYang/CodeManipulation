package me.sungbin;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void getterSetter() {
        Member member = new Member();
        member.setName("sungbin");

        assertEquals(member.getName(), "sungbin");
    }
}
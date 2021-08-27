package com.revature.accessmods2;

import com.revature.accessmods.driver;

public class follower2  extends driver{
	
	follower2 f2 = new follower2();
	
	int i = f2.pubField; //already exists because we are inheriting it
	int k = f2.procField; //this field is inherited from driver (can be self-referenced if procField is static)
}

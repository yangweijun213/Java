package com.jun.peformance;

import java.lang.management.ManagementFactory;

/**
 * @author jeff yang
 * ��ȡCPU,Memory
 *
 */
public class GetCpuMemory {

	public static void main(String[] args) {
		
		com.sun.management.OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
				.getOperatingSystemMXBean();
		
		System.out.println("Java ��������ʹ�õĴ�������Ŀ: "+operatingSystemMXBean.getAvailableProcessors());
		System.out.println("total physical memory(MB): "+operatingSystemMXBean.getTotalPhysicalMemorySize());
		System.out.println("free physical memory(MB): "+operatingSystemMXBean.getFreePhysicalMemorySize());
		System.out.println("total swap space(MB): "+operatingSystemMXBean.getTotalSwapSpaceSize());
		
	}

}

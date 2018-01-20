package com.atguigu.atcrowdfunding.vo;

import java.util.List;

public class Page<T> {

		private List<T> datas;//每页显示的数据
		
		private int totalno;//总页数
		private int pageno;//当前页
		private int totalsize;//所有数据
		private int pagesize;//每页显示的数据条数
		
		public Page(int pageno, int pagesize) {
			if (pageno<=0) {
				this.pageno = 1;
			}else {
				this.pageno = pageno;
			}
			/*if (pagesize<=0) {
				this.pagesize = 10;
			}else {
				this.pagesize = pagesize;
			}*/
			this.pagesize = pagesize<=0?10:pagesize;
		}
		
		public List<T> getDatas() {
			return datas;
		}
		public void setDatas(List<T> datas) {
			this.datas = datas;
		}
		public int getTotalno() {
			return totalno;
		}
		private void setTotalno(int totalno) {
			this.totalno = totalno;
		}
		public int getPageno() {
			return pageno;
		}
		public void setPageno(int pageno) {
			this.pageno = pageno;
		}
		public int getTotalsize() {
			return totalsize;
		}
		public void setTotalsize(int totalsize) {
			this.totalsize = totalsize;
			this.totalno = (totalsize % pagesize) > 0?((totalsize / pagesize)+1):(totalsize / pagesize);
			/*if (totalsize % pagesize > 0 ) {
				this.totalno = (this.totalsize / (pagesize+ 1)) ;
			} else {
				this.totalno = (this.totalsize / pagesize);
			}*/
		}
		public int getPagesize() {
			return pagesize;
		}
		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}
		
		public Integer getStartindex() {
			return (pageno-1) * pagesize;
		}

		@Override
		public String toString() {
			return "[ totalno=" + totalno + ", pageno=" + pageno + ", totalsize=" + totalsize
					+ ", pagesize=" + pagesize + "]";
		}

		
		
	}


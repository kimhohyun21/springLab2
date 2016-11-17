package com.sist.mgr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import java.util.*;


@Component("mm")
public class MovieManager {
	@Autowired
	public MovieDAO dao;
	
	public List<String> list=new ArrayList<String>();
	
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		MovieManager mm=(MovieManager) app.getBean("mm");
		mm.list.clear(); //초기화
		
		for(int i=1;i<=20;i++){
			mm.getData(i);
		}
		int j=1;
		for(String code : mm.list){
			System.out.println("j="+j);
			mm.movieInfoData(j, code);			
			j++;
			
		}
		System.out.println("end");
	}
	
	//소스코드에서 href의 code정보를 얻는 메서드
	public void getData(int page){
		try{
			Document doc=
			Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20161115&page="+page).get();
			
			Elements codes=doc.select("div.tit5 a");
			for(int i=0;i<codes.size();i++){
				Element atag=codes.get(i);
				String href=atag.attr("href");
				//System.out.println("http://movie.naver.com/"+href);
				list.add(href.substring(href.lastIndexOf("=")+1));
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//얻어진 Code번호에서 세부 정보를 얻는 메서드
	public void movieInfoData(int r, String code){
		try{
			Document doc=
			Jsoup.connect("http://movie.naver.com/movie/bi/mi/basic.nhn?code="+code).get();
			Element titleElem=doc.select("div.mv_info h3.h_movie a").first();
			Element genreElem=doc.select("p.info_spec span a").first();
			Element directorElem=doc.select("dl.step1 dd a").first();
			System.out.println(titleElem.text());
			//actor
			Elements actorElems=doc.select("dl.step2 dd a"); //복수개를 받아옴
			String actor="";
			for(int i=0;i<actorElems.size();i++){
				Element elem=actorElems.get(i);
				actor+=elem.text()+",";	
			}
			/*actor=actor.substring(0, actor.lastIndexOf(","));*/
			
			//poster
			Element posterElem=doc.select("div.poster a img").first();
			String img=posterElem.attr("src");
			
			//grade
			Elements spanElems=doc.select("p.info_spec span a"); 
			String grade="";
			for(int i=0;i<spanElems.size();i++){
				Element elem=spanElems.get(i);
				String str=elem.attr("href");
				str=str.substring(str.lastIndexOf("?")+1, str.lastIndexOf("=")); //주소값에 파라미터 중 grade를 갖고 있는 주소를 찾음
				if(str.equals("grade")){
					grade=elem.text();
					break;
				}
			}
			
			//star
			Element starElem=doc.select("div.star_score span.st_on").first();
			String star="";
			if(starElem.text().equals("관람객 평점 없음")){
				star="0";
			}else{
				star=starElem.text().replaceAll("[가-핳]", "");
			}
			
			//story
			Element storyElem=doc.select("div.story_area p.con_tx").first();
			String story=storyElem.text();
			story=story.replaceAll("[A-Za-z]", "");
			story=story.replace("'", "");
			story=story.replace("&", "");
			
			if(titleElem.text()!=null){
				/*System.out.println(titleElem.text()+" "
									+genreElem.text()+" "
									+directorElem.text()+" "
									+actor+img+grade+star);*/
				MovieVO vo=new MovieVO();
				vo.setTitle(titleElem.text());
				vo.setDirector(directorElem.text());
				vo.setActor(actor);
				vo.setGenre(genreElem.text());
				vo.setPoster(img);
				vo.setStory(story);
				vo.setStar(star);
				vo.setRank(String.valueOf(r));
				vo.setGrade(grade);
				dao.movieInsert(vo);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

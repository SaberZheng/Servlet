package ecut.listener.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 这是一个用来操作文件的工具类
 */
public final class FileHelper {
	
	public static void main(String[] args) {
		System.out.println( Integer.MAX_VALUE );
		System.out.println( 1 << 25 );
		System.out.println( Integer.MAX_VALUE > ( 1 << 25 ) );
		String s = "d7497e614856d8f41b55b7ddabf82142" ;
		System.out.println( s.toUpperCase() );
		
		long start = System.currentTimeMillis() ;//System.nanoTime() ;
		String x = digest( new File( "/Users/BOINN/Downloads/mysql-5.7.17-win32.zip" ) );
		long end = System.currentTimeMillis() ;//System.nanoTime();
		
		System.out.println( x );
		System.out.println( end - start );
		
		start = System.currentTimeMillis() ;//System.nanoTime() ;
		x = digest( "/Users/BOINN/Downloads/mysql-5.7.17-win32.zip" );
		end = System.currentTimeMillis() ;//System.nanoTime();
		System.out.println( x );
		System.out.println( end - start );
	}

	private static final int BUFFER_SIZE = 1 << 20 ; // 1MB
	
	private static final byte[] BUFFER = new byte[ BUFFER_SIZE ];
	
	private static final byte BUFFER_DEFAULT = 0 ;
	
	protected static void clearBuffer(){
		Arrays.fill( BUFFER ,  BUFFER_DEFAULT );
	}
	
	/***
	 * 根据给定的文件名称，计算该文件的 MD5 摘要 ( 基于 NIO 实现 )
	 * @param filename 需要计算MD5摘要的文件名称 ( 需要指定具体的路径 )
	 * @return 返回指定文件名称的文件对应的 MD5 摘要
	 */
	public static String digest( String filename ) {
		
		if( StringHelper.empty( filename ) ){
			throw new RuntimeException( "你没有指定需要求取MD5的文件" );
		} else {
			
			Path path = Paths.get( filename );
			
			File file = path.toFile();
			
			if( file.exists() ){
				
				if( file.isDirectory() ) {
					throw new RuntimeException( "我只能求文件的MD5，你设定的是目录哦！" );
				}
				
				if( file.isFile() ) {
					
					FileChannel channel = null ;
					
					try {
						
						MessageDigest md = digest();
						
						channel = FileChannel.open( path , StandardOpenOption.READ );
						final long size = channel.size();
						final long x = size / BUFFER_SIZE ;
						final int remainder = (int)( size % BUFFER_SIZE  );
						MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,  0 , size);
						
						for( int i = 0 ; i < x ; i++ ){
							buffer.get( BUFFER );
							md.update( BUFFER );
						}
						
						if( remainder != 0 ){
							buffer.get(BUFFER, 0, remainder );
							md.update( BUFFER,  0 , remainder );
						}
						
						BigInteger bigInt = new BigInteger( 1, md.digest() );
						return bigInt.toString(16).toUpperCase() ;
						
					} catch (IOException e) {
						throw new RuntimeException( "计算失败" , e );
					} finally {
						if( channel != null ){
							try {
								channel.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					
				}
				
				throw new RuntimeException( "你确定指定的是个文件，并且可以被访问?" );
				
			} else {
				throw new RuntimeException( "你指定的文件不存在" );
			}
		}

	}
	
	/**
	 * 计算一个文件对应的 MD5 摘要
	 * @param file 需要计算 MD5 摘要的文件
	 * @return 返回指定文件的 MD5 摘要
	 */
	public static String digest( File file ) {
		
		if ( file !=null && file.exists() &&  file.isFile()) {
			
			MessageDigest digest = digest();
			FileInputStream in = null;
			int len;
			try {
				in = new FileInputStream(file);
				while ((len = in.read( BUFFER )) != -1) {
					digest.update(BUFFER, 0, len);
				}
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			BigInteger bigInt = new BigInteger(1, digest.digest());
			return bigInt.toString(16).toUpperCase();
			
		}
		
		return null ;
	}
	
	/**
	 * 获得 MD5 算法对应的 MessageDigest 对象
	 */
	private static MessageDigest digest(){
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException( "不支持MD5算法" , e );
		}
		return digest ;
	}

	/**
	 * 获取文件夹中文件的MD5摘要
	 * 
	 * @param file
	 * @param listChild
	 *            ;true递归子目录中的文件
	 * @return
	 */
	protected static Map<String, String> getDirMD5(File file, boolean listChild) {
		if (!file.isDirectory()) {
			return null;
		}
		// <filepath,md5>
		Map<String, String> map = new HashMap<String, String>();
		String md5;
		File files[] = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory() && listChild) {
				map.putAll(getDirMD5(f, listChild));
			} else {
				md5 = digest(f);
				if (md5 != null) {
					map.put(f.getPath(), md5);
				}
			}
		}
		return map;
	}

}

package com.filedownload.main

import scala.io.Source
import java.net.URLConnection
import java.net.URL
import java.util.zip.GZIPInputStream
import java.io.FileInputStream
import java.io.BufferedInputStream
import java.util.zip.GZIPOutputStream
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.FileNotFoundException

object FileDownloadMain extends App {

  println("Println process started")

  val baseFileName = "https://data.githubarchive.org/"
  var fileExtension = ".json.gz"
  var hyphen = "-"
  var zero = "0" 
  var year = 2017
  var changeDate = false
  var newDate = 0

  for (month <- 5 to 12) {
    for (date <- 12 to 30) {
      for (index <- 1 to 20) {
        var fileName = baseFileName + year + hyphen 
        
          fileName =  fileName + checkNumber(month) + hyphen + checkNumber(date) + hyphen  + index + fileExtension
          var outputFileName = year + hyphen + checkNumber(month) + hyphen + checkNumber(date) + hyphen  + index + fileExtension
        
         //println("fileName ==> " + fileName)
        
        try {
          val url = new URL(fileName)
          val urlConnection = url.openConnection()
          urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
          var in = new GZIPInputStream(new BufferedInputStream(urlConnection.getInputStream))

          var fos = new FileOutputStream("C://Users//mpram//workspace-scala//FileDownloader//full_month_output//"+ outputFileName)
          var gzos = new GZIPOutputStream(fos)
          var w = new PrintWriter(gzos)

          for (line <- Source.fromInputStream(in).getLines()) {
            //println(line)
            w.write(line + "\n")
          }
          
          w.close()
          gzos.close()
          fos.close()
          in.close()
          
          println("Finished writing file InputFileName ==>" + fileName + "output file name ==> " + outputFileName)
          
          
          
          

        } catch {
          case fnf : FileNotFoundException =>  { println("File Not Found " + fileName) 
          fnf.printStackTrace()
          }  
          case e: Exception => e.printStackTrace()
        }
        finally {
         
        }
        
      }
    }
  }
  println("Println process ended")
  
  def checkNumber(i: Int) : String = if(i < 10) zero + i else i.toString()
  def getDate(fileName: String):String  = fileName.substring(39, 40) 

}
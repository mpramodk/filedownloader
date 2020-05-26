package com.filedownload.main

import java.io.PrintWriter
import java.io.FileOutputStream
import java.io.FileNotFoundException
import java.io.BufferedInputStream
import java.util.zip.GZIPOutputStream
import java.util.zip.GZIPInputStream
import java.net.URL
import scala.io.Source

object FromBase extends App  {/*
  
  
          try {
          val url = new URL("https://data.githubarchive.org/2011-02-12-7.json.gz")
          val urlConnection = url.openConnection()
          urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
          var in = new GZIPInputStream(new BufferedInputStream(urlConnection.getInputStream))

          var fos = new FileOutputStream(fileName)
          var gzos = new GZIPOutputStream(fos)
          var w = new PrintWriter(gzos)

          for (line <- Source.fromInputStream(in).getLines()) {
            println(line)
            w.write(line + "\n")
          }
          
          w.close()
          gzos.close()
          fos.close()
          in.close()
          
          println("Finished writing file " + fileName)
          
          
          
          

        } catch {
          case fnf : FileNotFoundException =>  { println("File Not Found " ) 
          fnf.printStackTrace()
          }  
          case e: Exception => e.printStackTrace()
        }
        finally {
         
        }

  
*/}
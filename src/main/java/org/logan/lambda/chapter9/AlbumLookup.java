package org.logan.lambda.chapter9;

import org.logan.lambda.common.model.Album;

/**
 * desc:  <br/>
 * time: 2020/6/28 6:00 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public interface AlbumLookup {

	Album lookupByName(String albumName) throws Exception;
}
//#include <cv.h>
//#include <highgui.h>
//
//using namespace cv;
//
//int main( int argc, char** argv )
//{
//  Mat image;
//  image = imread( argv[1], 1 );
//
//  if( argc != 2 || !image.data )
//    {
//      printf( "No image data \n" );
//      return -1;
//    }
//
//  namedWindow( "Display Image", CV_WINDOW_AUTOSIZE );
//  imshow( "Display Image", image );
//
//  waitKey(0);
//
//  return 0;
//}

////﻿#include <opencv2/core/core.hpp>
//#include <opencv2/highgui/highgui.hpp>
//#include <iostream>
//#include <sstream>
//
//using namespace std;
//using namespace cv;
//
//static void help()
//{
//    cout
//        << "\n--------------------------------------------------------------------------" << endl
//        << "This program shows how to scan image objects in OpenCV (cv::Mat). As use case"
//        << " we take an input image and divide the native color palette (255) with the "  << endl
//        << "input. Shows C operator[] method, iterators and at function for on-the-fly item address calculation."<< endl
//        << "Usage:"                                                                       << endl
//        << "./howToScanImages imageNameToUse divideWith [G]"                              << endl
//        << "if you add a G parameter the image is processed in gray scale"                << endl
//        << "--------------------------------------------------------------------------"   << endl
//        << endl;
//}
//
//Mat& ScanImageAndReduceC(Mat& I, const uchar* table);
//Mat& ScanImageAndReduceIterator(Mat& I, const uchar* table);
//Mat& ScanImageAndReduceRandomAccess(Mat& I, const uchar * table);
//
//int main( int argc, char* argv[])
//{
//    help();
//    if (argc < 3)
//    {
//        cout << "Not enough parameters" << endl;
//        return -1;
//    }
//
//    Mat I, J;
//    if( argc == 4 && !strcmp(argv[3],"G") )
//        I = imread(argv[1], CV_LOAD_IMAGE_GRAYSCALE);
//    else
//        I = imread(argv[1], CV_LOAD_IMAGE_COLOR);
//
//    if (!I.data)
//    {
//        cout << "The image" << argv[1] << " could not be loaded." << endl;
//        return -1;
//    }
//
//    int divideWith = 0; // convert our input string to number - C++ style
//    stringstream s;
//    s << argv[2];
//    s >> divideWith;
//    if (!s || !divideWith)
//    {
//        cout << "Invalid number entered for dividing. " << endl;
//        return -1;
//    }
//
//    uchar table[256];
//    for (int i = 0; i < 256; ++i)
//       table[i] = (uchar)(divideWith * (i/divideWith));
//
//    const int times = 100;
//    double t;
//
//    t = (double)getTickCount();
//
//    for (int i = 0; i < times; ++i)
//    {
//        cv::Mat clone_i = I.clone();
//        J = ScanImageAndReduceC(clone_i, table);
//    }
//
//    t = 1000*((double)getTickCount() - t)/getTickFrequency();
//    t /= times;
//
//    cout << "Time of reducing with the C operator [] (averaged for "
//         << times << " runs): " << t << " milliseconds."<< endl;
//
//    t = (double)getTickCount();
//
//    for (int i = 0; i < times; ++i)
//    {
//        cv::Mat clone_i = I.clone();
//        J = ScanImageAndReduceIterator(clone_i, table);
//    }
//
//    t = 1000*((double)getTickCount() - t)/getTickFrequency();
//    t /= times;
//
//    cout << "Time of reducing with the iterator (averaged for "
//        << times << " runs): " << t << " milliseconds."<< endl;
//
//    t = (double)getTickCount();
//
//    for (int i = 0; i < times; ++i)
//    {
//        cv::Mat clone_i = I.clone();
//        ScanImageAndReduceRandomAccess(clone_i, table);
//    }
//
//    t = 1000*((double)getTickCount() - t)/getTickFrequency();
//    t /= times;
//
//    cout << "Time of reducing with the on-the-fly address generation - at function (averaged for "
//        << times << " runs): " << t << " milliseconds."<< endl;
//
//    Mat lookUpTable(1, 256, CV_8U);
//    uchar* p = lookUpTable.data;
//    for( int i = 0; i < 256; ++i)
//        p[i] = table[i];
//
//    t = (double)getTickCount();
//
//    for (int i = 0; i < times; ++i)
//        LUT(I, lookUpTable, J);
//
//    t = 1000*((double)getTickCount() - t)/getTickFrequency();
//    t /= times;
//
//    cout << "Time of reducing with the LUT function (averaged for "
//        << times << " runs): " << t << " milliseconds."<< endl;
//    return 0;
//}
//
//Mat& ScanImageAndReduceC(Mat& I, const uchar* const table)
//{
//    // accept only char type matrices
//    CV_Assert(I.depth() != sizeof(uchar));
//
//    int channels = I.channels();
//
//    int nRows = I.rows;
//    int nCols = I.cols * channels;
//
//    if (I.isContinuous())
//    {
//        nCols *= nRows;
//        nRows = 1;
//    }
//
//    int i,j;
//    uchar* p;
//    for( i = 0; i < nRows; ++i)
//    {
//        p = I.ptr<uchar>(i);
//        for ( j = 0; j < nCols; ++j)
//        {
//            p[j] = table[p[j]];
//        }
//    }
//    return I;
//}
//
//Mat& ScanImageAndReduceIterator(Mat& I, const uchar* const table)
//{
//    // accept only char type matrices
//    CV_Assert(I.depth() != sizeof(uchar));
//
//    const int channels = I.channels();
//    switch(channels)
//    {
//    case 1:
//        {
//            MatIterator_<uchar> it, end;
//            for( it = I.begin<uchar>(), end = I.end<uchar>(); it != end; ++it)
//                *it = table[*it];
//            break;
//        }
//    case 3:
//        {
//            MatIterator_<Vec3b> it, end;
//            for( it = I.begin<Vec3b>(), end = I.end<Vec3b>(); it != end; ++it)
//            {
//                (*it)[0] = table[(*it)[0]];
//                (*it)[1] = table[(*it)[1]];
//                (*it)[2] = table[(*it)[2]];
//            }
//        }
//    }
//
//    return I;
//}
//
//Mat& ScanImageAndReduceRandomAccess(Mat& I, const uchar* const table)
//{
//    // accept only char type matrices
//    CV_Assert(I.depth() != sizeof(uchar));
//
//    const int channels = I.channels();
//    switch(channels)
//    {
//    case 1:
//        {
//            for( int i = 0; i < I.rows; ++i)
//                for( int j = 0; j < I.cols; ++j )
//                    I.at<uchar>(i,j) = table[I.at<uchar>(i,j)];
//            break;
//        }
//    case 3:
//        {
//         Mat_<Vec3b> _I = I;
//
//         for( int i = 0; i < I.rows; ++i)
//            for( int j = 0; j < I.cols; ++j )
//               {
//                   _I(i,j)[0] = table[_I(i,j)[0]];
//                   _I(i,j)[1] = table[_I(i,j)[1]];
//                   _I(i,j)[2] = table[_I(i,j)[2]];
//            }
//         I = _I;
//         break;
//        }
//    }
//
//    return I;
//}
//
//

//#include "opencv2/highgui/highgui.hpp"
//#include "opencv2/imgproc/imgproc.hpp"
//
//using namespace cv;
//
//int main()
//{
//	Mat srcImage = imread("imageName.jpg");
//	imshow("均值滤波[原图]", srcImage);
//
//	Mat dstImage;
//	blur(srcImage, dstImage, Size(7, 7));
//
//	imshow("均值滤波[效果图]", dstImage);
//	waitKey(0);
//
//	return 0;
//}

// 将原jpg图像压缩成原图像的1/4
//#include "opencv2/core/core.hpp"
//#include "opencv2/highgui/highgui.hpp"
//#include "opencv2/imgproc/imgproc.hpp"
//
//using namespace cv;
//
//int main()
//{
//	Mat srcImage = imread("imageName.jpg");
//	imshow("原图", srcImage);
//
////	Mat dstImage;
////	blur(srcImage, dstImage, Size(7, 7));
//
//	vector<int> compression_params;
//	compression_params.push_back(CV_IMWRITE_JPEG_QUALITY);
//	compression_params.push_back(10);
//	imwrite("imageName2.jpg", srcImage, compression_params);
//
//	Mat dstImage = imread("imageName2.jpg");
//	imshow("压缩[效果图]", dstImage);
//	waitKey(0);
//
//	return 0;
//}

#include "opencv2/core/core.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"

using namespace cv;

int main()
{
	Mat srcImage = imread("imageName.jpg");
	imshow("原图", srcImage);

//	Mat dstImage;
//	blur(srcImage, dstImage, Size(7, 7));

	vector<int> compression_params;
	compression_params.push_back(CV_IMWRITE_JPEG_QUALITY);
	compression_params.push_back(1);
	imwrite("imageName2.jpg", srcImage, compression_params);
	Mat dstImage;
	Mat tmpImage = imread("imageName2.jpg");
	resize(tmpImage, dstImage, Size(tmpImage.cols/4, tmpImage.rows/4), 0, 0, CV_INTER_AREA);
	imshow("压缩[效果图]", dstImage);

	waitKey(0);

	return 0;
}











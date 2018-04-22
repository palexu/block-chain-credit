<template>
  <!-- Header -->
  <div>
    <header class="header">
      <div class="container clearfix">
        <div class="header-inner flex space-between items-center">
          <div class="left">
            <div class="logo"><a href="index.html"><p>征信开放平台</p></a></div>
          </div> <!-- end .left -->
          <div class="right flex space-between no-column items-center">
            <div class="navigation">
              <nav class="main-nav">
                <ul class="list-unstyled">
                  <li><a href="index.html">首页</a></li>
                  <li><a href="about.html">文档</a></li>
                  <li><a href="contact.html">关于</a></li>
                </ul>
              </nav> <!-- end .main-nav -->
              <a href="" class="responsive-menu-open"><i class="ion-navicon"></i></a>
            </div> <!-- end .navigation -->
            <div class="button-group-merged flex no-column">
              <a href="#" class="button">机构登陆</a>
              <a href="#register" class="button" data-toggle="modal" data-target=".bs-modal-sm">个人登陆</a>
            </div> <!-- end .button-group-merged -->
          </div> <!-- end .right -->
        </div> <!-- end .header-inner -->
      </div> <!-- end .container -->
    </header> <!-- end .header -->

    <!-- Responsive Menu -->
    <div class="responsive-menu">
      <a href="" class="responsive-menu-close"><i class="ion-android-close"></i></a>
      <nav class="responsive-nav"></nav> <!-- end .responsive-nav -->
    </div> <!-- end .responsive-menu -->

    <!-- Login/Signup Popup -->
    <div class="modal fade bs-modal-sm" aria-hidden="true" aria-labelledby="myTabContent" id="login-signup-popup"
         role="dialog" tabindex="-1">
      <div class="modal-dialog modal-sm login-signup-modal">
        <div class="modal-content">
          <div class="popup-tabs">
            <ul class="nav nav-tabs" id="myTab">
              <li class=""><a data-toggle="tab" href="#login">login</a></li>
              <li class="active"><a data-toggle="tab" href="#register">Register</a></li>
            </ul>
          </div> <!-- end .popup-tabs -->
          <div class="modal-body">
            <div class="tab-content" id="myTabContent">
              <div class="tab-pane fade" id="login">
                <form class="login-form">

                  <div class="form-group">
                    <label for="InputEmail1">Your Email *</label>
                    <input type="email" class="form-control" id="InputEmail1" placeholder="Enter your email">
                  </div>

                  <div class="form-group">
                    <label for="InputPassword1">Password *</label>
                    <input type="password" class="form-control" id="InputPassword1" placeholder="Password">
                  </div>

                  <div class="checkbox flex space-between">
                    <div>
                      <input id="sigin-checkbox" type="checkbox">
                      <label for="sigin-checkbox">Remember me</label>
                    </div>
                    <a href="#0">Lost password?</a>
                  </div> <!-- end .checkbox -->

                  <button type="button" class="button" data-dismiss="modal">Login</button>

                  <p class="text-center divider-text small"><span>or login using</span></p>

                  <div class="social-buttons">
                    <ul class="list-unstyled flex space-between">
                      <li class="twitter-btn"><a href="#0"><i class="ion-social-twitter"></i></a></li>
                      <li class="fb-btn"><a href="#0"><i class="ion-social-facebook"></i></a></li>
                      <li class="g-plus-btn"><a href="#0"><i class="ion-social-googleplus"></i></a></li>
                    </ul>
                  </div> <!-- end .social-buttons -->

                </form> <!-- end .login-form -->
              </div> <!-- end login-tab-content -->

              <div class="tab-pane fade active in" id="register">
                <form class="signup-form">
                  <div class="form-group">
                    <label for="InputEmail1">Your Email *</label>
                    <input type="email" class="form-control" id="InputEmail2" placeholder="Enter your email">
                  </div>

                  <div class="form-group">
                    <label for="InputPassword1">Password *</label>
                    <input type="password" class="form-control" id="InputPassword2" placeholder="Password">
                  </div>

                  <div class="form-group">
                    <label for="InputPassword2">Confirm Password *</label>
                    <input type="password" class="form-control" id="InputPassword3" placeholder="Password">
                  </div>

                  <div class="form-group">
                    <label for="select1">Register as:</label>
                    <div class="select-wrapper">
                      <select class="form-control" id="select1">
                        <option>Candidate</option>
                        <option>Company</option>
                      </select>
                    </div> <!-- end .select-wrapper -->
                  </div>

                  <div class="checkbox">
                    <input id="signup-checkbox" type="checkbox">
                    <label for="signup-checkbox">I agree with the Terms of Use</label>
                  </div> <!-- end .checkbox -->

                  <button type="button" class="button" data-dismiss="modal">Sign Up</button>

                  <p class="text-center divider-text small"><span>or login using</span></p>

                  <div class="social-buttons">
                    <ul class="list-unstyled flex space-between">
                      <li class="twitter-btn"><a href="#0"><i class="ion-social-twitter"></i></a></li>
                      <li class="fb-btn"><a href="#0"><i class="ion-social-facebook"></i></a></li>
                      <li class="g-plus-btn"><a href="#0"><i class="ion-social-googleplus"></i></a></li>
                    </ul>
                  </div> <!-- end .social-buttons -->

                </form> <!-- end .signup-form -->
              </div> <!-- end signup-tab-content -->
            </div> <!-- end .mytabcontent -->
          </div> <!-- end .modal-body -->
        </div> <!-- end .modal-content -->
      </div> <!-- end .modal-dialog -->
    </div> <!-- end .modal -->

    <!-- Hero Section -->
    <div class="section hero-section transparent" style="background-image: url('static/images/background01.jpg');">
      <div class="inner">
        <div class="container">
          <div class="job-search-form">
            <h2>超过<span>100,000<sup>+</sup></span>征信数据</h2>
            <form class="form-inline flex">
              <div class="form-group">
                <div class="form-group-inner">
                  <input type="text" class="form-control" id="input-field-1"
                         placeholder="job title / Keywords / company name">
                  <i class="ion-ios-briefcase-outline"></i>
                </div>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="input-field-2" placeholder="city / province / zip code">
                <i class="ion-ios-location-outline"></i>
              </div>
              <button type="submit" class="button"><i class="ion-ios-search-strong"></i></button>
            </form>
            <div class="keywords flex">
              <h4 class="self-center">Popular Keywords:</h4>
              <a href="#0" class="button item-center">web design</a>
              <a href="#0" class="button item-center">accountant</a>
              <a href="#0" class="button item-center">car dealer</a>
            </div> <!-- end .keywords -->
          </div> <!-- end .job-search-form -->
        </div> <!-- end .container -->
        <div class="features-bar">
          <div class="container">
            <div class="features-bar-inner flex space-between">
              <div class="features-box self-center">
                <h3>Leading the industry</h3>
                <a href="about.html">About us<i class="ion-ios-arrow-thin-right"></i></a>
              </div> <!-- end .feature-box -->
              <div class="features-box-icon flex no-wrap">
                <img src="static/images/feature-icon01.png" alt="cup-icon" class="img-responsive self-center">
                <div class="content self-center">
                  <h3>High average salary</h3>
                  <a href="#0">Learn more<i class="ion-ios-arrow-thin-right"></i></a>
                </div> <!-- end .content -->
              </div> <!-- end .feature-box-icon -->
              <div class="features-box-icon flex no-wrap">
                <img src="static/images/feature-icon02.png" alt="cup-icon" class="img-responsive self-center">
                <div class="content self-center">
                  <h3>2,500,000+ candidates</h3>
                  <a href="#0">Our community<i class="ion-ios-arrow-thin-right"></i></a>
                </div> <!-- end .content -->
              </div> <!-- end .feature-box-icon -->
              <div class="user-profile-icon self-center">
                <img src="static/images/profile-icon01.png" alt="profile-icon" class="img-responsive self-center">
              </div> <!-- end .profile-icon -->
            </div> <!-- end .features-bar-inner -->
          </div> <!-- end .container -->
        </div> <!-- end .features-bar -->
      </div> <!-- end .inner -->
    </div> <!-- end .section -->

    <!-- Featured Jobs Section -->
    <div class="section featured-jobs-section">
      <div class="inner">
        <div class="container">
          <div class="section-top-content flex items-center">
            <h1>Featured Jobs</h1>
            <a href="#0">View all jobs<i class="ion-ios-arrow-thin-right"></i></a>
          </div> <!-- end .section-top-content -->
          <div class="jobs-table">
            <div class="table-header">
              <div class="table-cells flex">
                <div class="job-title-cell"><h6>Job title / Company name</h6></div>
                <div class="job-type-cell"><h6>Type</h6></div>
                <div class="location-cell"><h6>Location</h6></div>
                <div class="expired-date-cell"><h6>Expired Date</h6></div>
                <div class="salary-cell"><h6>Salary</h6></div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-header -->

            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo01.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Web Designer needed</a></h4>
                    <p class="small">Quick studio</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button full-time">Full time</button>
                </div> <!-- end .job-type-cell -->
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div> <!-- end .location-cell -->
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired Date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div> <!-- end .expire-date-cell -->
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div> <!-- end .salray-cell -->
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->

            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo02.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">We're hiring a fullstack developer</a></h4>
                    <p class="small">Archive inc.</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button part-time">Part time</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->

            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo03.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Looking for a project leader</a></h4>
                    <p class="small">Comply agency</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button full-time">Full time</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired Date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->

            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo04.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Front-end developer needed</a></h4>
                    <p class="small">Folder cooperation</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button freelancer">freelancer</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->

            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo05.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Software Engineer</a></h4>
                    <p class="small">Bookcover publisher</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button full-time">Full time</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->

            <div class="table-footer flex space-between items-center">
              <h6>Showing<span>1-5</span>of 23 jobs</h6>
              <div class="jobpress-custom-pager list-unstyled flex space-between no-column items-center">
                <a href="#0" class="button"><i class="ion-ios-arrow-left"></i>Prev</a>
                <ul class="list-unstyled flex no-column items-center">
                  <li><a href="#0">1</a></li>
                  <li><a href="#0">2</a></li>
                  <li><a href="#0">3</a></li>
                  <li><a href="#0">4</a></li>
                  <li><a href="#0">5</a></li>
                </ul>
                <a href="#0" class="button">Next<i class="ion-ios-arrow-right"></i></a>
              </div> <!-- end .jobpress-custom-pager -->
            </div>
          </div> <!-- end .jobs-table -->
        </div> <!-- end .container -->
      </div> <!-- end .inner -->
    </div> <!-- end .section -->

    <!-- Category Section -->
    <div class="section category-section solid-blue-bg">
      <div class="inner">
        <div class="container">
          <h1 class="light">Browse Categories</h1>
          <div class="category-grid">
            <div class="category-row flex no-wrap space-between items-center">
              <div class="item">
                <img src="static/images/category-icon01.png" alt="category-icon" class="img-responsive">
                <h4>Finance</h4>
                <p class="light">4286 Jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon02.png" alt="category-icon" class="img-responsive">
                <h4>Construction</h4>
                <p class="light">452 Jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon03.png" alt="category-icon" class="img-responsive">
                <h4>Logistics</h4>
                <p class="light">1867 Jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon04.png" alt="category-icon" class="img-responsive">
                <h4>Art/Design</h4>
                <p class="light">3094 jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon05.png" alt="category-icon" class="img-responsive">
                <h4>Sales/Marketing</h4>
                <p class="light">2955 jobs</p>
              </div> <!-- end .item -->
            </div> <!-- end .category-row -->

            <div class="category-row flex no-wrap space-between items-center">
              <div class="item">
                <img src="static/images/category-icon06.png" alt="category-icon" class="img-responsive">
                <h4>Science</h4>
                <p class="light">470 Jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon07.png" alt="category-icon" class="img-responsive">
                <h4>Technologies</h4>
                <p class="light">4536 Jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon08.png" alt="category-icon" class="img-responsive">
                <h4>Healthcare</h4>
                <p class="light">2619 Jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon09.png" alt="category-icon" class="img-responsive">
                <h4>Education/Training</h4>
                <p class="light">1132 jobs</p>
              </div> <!-- end .item -->
              <div class="item">
                <img src="static/images/category-icon10.png" alt="category-icon" class="img-responsive">
                <h4>Food Services</h4>
                <p class="light">757 jobs</p>
              </div> <!-- end .item -->
            </div> <!-- end .category-row -->
          </div>  <!-- end .category-grid -->
        </div> <!-- end .container -->
      </div> <!-- end .inner -->
      <div class="background-text">
        <h1>Categories</h1>
      </div> <!-- end .background-text -->
    </div> <!-- end .section -->

    <!-- Latest Jobs Section -->
    <div class="section Latest-jobs-section">
      <div class="inner">
        <div class="container">
          <div class="section-top-content flex items-center">
            <h1>Latest Jobs</h1>
            <a href="#0">View all jobs<i class="ion-ios-arrow-thin-right"></i></a>
          </div> <!-- end .section-top-content -->
          <div class="jobs-table">
            <div class="table-header">
              <div class="table-cells flex">
                <div class="job-title-cell"><h6>Job title / Company name</h6></div>
                <div class="job-type-cell"><h6>Type</h6></div>
                <div class="location-cell"><h6>Location</h6></div>
                <div class="expired-date-cell"><h6>Expired Date</h6></div>
                <div class="salary-cell"><h6>Salary</h6></div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-header -->
            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo06.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Web Designer needed</a></h4>
                    <p class="small">Whale creative</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button full-time">Full time</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->
            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo07.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">We're hiring a fullstack developer</a></h4>
                    <p class="small">Banana inc.</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button part-time">Part time</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->
            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo08.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Looking for a project leader</a></h4>
                    <p class="small">Elephant studio</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button full-time">Full time</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->
            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo09.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Front-end developer needed</a></h4>
                    <p class="small">Med-Equal</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button freelancer">freelancer</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->
            <div class="table-row">
              <div class="table-cells flex no-wrap">
                <div class="cell job-title-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Company name</h6>
                  </div> <!-- end .cell-label -->
                  <img src="static/images/company-logo10.jpg" alt="company-logo" class="img-responsive">
                  <div class="content">
                    <h4><a href="#">Software Engineer</a></h4>
                    <p class="small">organicoo</p>
                  </div> <!-- end .content -->
                </div> <!-- end .job-title-cell -->
                <div class="cell job-type-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Type</h6>
                  </div> <!-- end .cell-label -->
                  <button type="button" class="button full-time">Full time</button>
                </div>
                <div class="cell location-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Location</h6>
                  </div> <!-- end .cell-label -->
                  <p>Cupertino<span>, CA, USA</span></p>
                </div>
                <div class="cell expired-date-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Expired date</h6>
                  </div> <!-- end .cell-label -->
                  <p>Nov 14th<sup>th</sup><span>, 2017</span></p>
                </div>
                <div class="cell salary-cell flex no-column no-wrap">
                  <div class="cell-mobile-label">
                    <h6>Salary</h6>
                  </div> <!-- end .cell-label -->
                  <p><sup>$</sup>60<span>/hour</span></p>
                </div>
              </div> <!-- end .table-cells -->
            </div> <!-- end .table-row -->
            <div class="table-footer flex space-between items-center">
              <h6>Showing<span>1-5</span>of 23 jobs</h6>
              <div class="jobpress-custom-pager list-unstyled flex space-between no-column items-center">
                <a href="#0" class="button"><i class="ion-ios-arrow-left"></i>Prev</a>
                <ul class="list-unstyled flex no-column items-center">
                  <li><a href="#0">1</a></li>
                  <li><a href="#0">2</a></li>
                  <li><a href="#0">3</a></li>
                  <li><a href="#0">4</a></li>
                  <li><a href="#0">5</a></li>
                </ul>
                <a href="#0" class="button">Next<i class="ion-ios-arrow-right"></i></a>
              </div> <!-- end .jobpress-custom-pager -->
            </div>
          </div> <!-- end .jobs-table -->
        </div> <!-- end .container -->
      </div> <!-- end .inner -->
    </div> <!-- end .section -->

    <div class="section cta-section parallax text-center"
         style="background-image: url('static/images/background02.jpg');">
      <div class="inner">
        <div class="container">
          <h2>Looking for a job</h2>
          <p class="large light">Join thousand of emplyers and earn what you deserve</p>
          <div class="cta-button">
            <a href="#" class="button">Get started now</a>
          </div> <!-- end .cta-button -->
        </div> <!-- end .container -->
      </div> <!-- end .inner -->
    </div> <!-- end .section -->


    <!-- Clients Section -->
    <div class="section clients-section solid-grey-bg">
      <div class="inner">
        <div class="container">
          <h1 class="section-title">Clients & Partners</h1>
          <div class="logo-grid">
            <div class="logo-grid-row flex space-between">
              <div class="logo-item flex">
                <img src="static/images/client-logo01.png" alt="client-company-logo" class="img-responsive self-center">
              </div> <!-- end .logo-item -->
              <div class="logo-item flex">
                <img src="static/images/client-logo02.png" alt="client-company-logo" class="img-responsive self-center">
              </div> <!-- end .logo-item -->
              <div class="logo-item flex">
                <img src="static/images/client-logo03.png" alt="client-company-logo" class="img-responsive self-center">
              </div> <!-- end .logo-item -->
              <div class="logo-item flex">
                <img src="static/images/client-logo04.png" alt="client-company-logo" class="img-responsive self-center">
              </div> <!-- end .logo-item -->
              <div class="logo-item flex">
                <img src="static/images/client-logo05.png" alt="client-company-logo" class="img-responsive self-center">
              </div> <!-- end .logo-item -->
              <div class="logo-item flex">
                <img src="static/images/client-logo06.png" alt="client-company-logo" class="img-responsive self-center">
              </div> <!-- end .logo-item -->
            </div> <!-- end .logo-grid-row -->
          </div> <!-- end .logo-grid -->
        </div> <!-- end .container -->
      </div> <!-- end .inner -->
    </div> <!-- end .section -->

    <!-- Footer -->
    <div class="section footer transparent" style="background-image: url('static/images/background03.jpg');">
      <div class="container">
        <div class="top flex space-between items-center">
          <img src="static/images/footer-logo.png" alt="footer-logo" class="img-responsive">
          <ul class="list-unstyled footer-menu flex">
            <li><a href="#0">Home</a></li>
            <li><a href="#0">About</a></li>
            <li><a href="#0">Browse Jobs</a></li>
            <li><a href="#0">Browse candidates</a></li>
            <li><a href="#0">Contact</a></li>
          </ul> <!-- end .footer-menu -->
        </div> <!-- end .top -->
      </div> <!-- end .container -->
    </div> <!-- end .footer -->
  </div>

</template>
<script>
  export default {
    name: 'Index'
  }
</script>

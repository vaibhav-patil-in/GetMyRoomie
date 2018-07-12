      <div id="header">
        <nav class="navbar navbar-default" role="navigation">
          <div class="container-fluid">
            
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Mobile Navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/">GetMyRoomie</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <form class="navbar-form navbar-right" role="search" action="/">
                <a href="/browseRoomMates"><span class="btn btn-success">Browse Roommates <span class="glyphicon glyphicon-user"></span></span></a>
                <a href="/browseRooms"><span class="btn btn-success">Browse Rooms <span class="glyphicon glyphicon-home"></span></span></a>

                <!-- <a href="/profileNeedARoom"><span class="btn btn-success">Need a Room <span class="glyphicon glyphicon-user"></span></span></a>
                <a href="/profileListARoom"><span class="btn btn-success">List your Room <span class="glyphicon glyphicon-home"></span></span></a>  -->

                <sec:authorize access="isAnonymous()">
                <a href="/profile"><span class="btn btn-success">Login</span></a>
                <a href="/getRegister"><span class="btn btn-success">Register</span></a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                <a href="/profile"><span class="btn btn-success">My Profile</span></a>
                <a href="/logout"><span class="btn btn-success">Log Out</span></a>
                </sec:authorize>
                
                <a href="#" data-toggle="modal" data-target="#myModalPostAd"><span class="btn btn-post-ad">POST AD</span></a>
				<!-- <a href="#" data-toggle="modal" data-target="#myModal"><span class="btn btn-success">About</span></a>  -->

              </form>
            </div><!-- /.navbar-collapse -->

          </div><!-- /.container-fluid -->
        </nav>
      </div>